package com.example.letsreviewserver.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.access-token-expiration}")
    private Long accessTokenExpirationMs;

    @Value("${jwt.refresh-token-expiration}")
    private Long refreshTokenExpirationMs;

    // Lazy-initialized SecretKey for Hashing
    private SecretKey secretKey;

    // Helper method to get the SecretKey from the secret string
    private SecretKey getSigningKey() {
        if (this.secretKey == null) {
            // It's important to use a strong, base64-encoded secret for production,
            // but for this example, we'll convert the string directly.
            // JJWT requires the key to be strong enough (>= 256 bits for HS256)
            this.secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
        }
        return this.secretKey;
    }

    public String generateAccessToken(String username) {
        return generateToken(username, accessTokenExpirationMs, false);
    }

    public String generateRefreshToken(String username) {
        return generateToken(username, refreshTokenExpirationMs, true);
    }

    private String generateToken(String username, Long expirationMs, Boolean refreshToken) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim("type", refreshToken ? "refresh" : "access") // Add token type claim
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.err.println("Expired JWT token: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.err.println("Unsupported JWT token: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("JWT claims string is empty: " + e.getMessage());
        }
        return false;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())  // always use your SecretKey
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isRefreshTokenValid(String token) {
        try {
            Claims claims = extractAllClaims(token);
            // Check expiration
            if (claims.getExpiration().before(new Date())) return false;
            // Check token type
            return "refresh".equals(claims.get("type", String.class));
        } catch (Exception e) {
            return false;
        }
    }
}