package com.example.letsreviewserver.auth;

import com.example.letsreviewserver.dto.auth.*;
import com.example.letsreviewserver.model.nondb.Role;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.JwtUtil;
import com.example.letsreviewserver.util.exception.CustomAuthenticationException;
import com.example.letsreviewserver.util.exception.DuplicateResourceException;
import com.example.letsreviewserver.util.exception.ResourceNotFoundException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${cookie.secure}")
    private Boolean secureCookie;

    @Value("${jwt.refresh-token-expiration}")
    private Long refreshTokenExpirationMs;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already in use");
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new DuplicateResourceException("Username already in use");
        }

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .createdDatetime(new Date())
                .createdBy(0L)
                .modifiedDatetime(new Date())
                .modifiedBy(0L)
                .build();

        userRepository.save(user);

        return new RegisterResponse(
                "User registered successfully",
                user.getUserId()
        );
    }

    public LoginResponse login(LoginRequest loginRequest, HttpServletResponse response) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        String accessToken = jwtUtil.generateAccessToken(user.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

        Cookie cookie = new Cookie("refresh_token", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(secureCookie);   // Set to false if running localhost without HTTPS
        cookie.setPath("/");
        cookie.setMaxAge((int) (long) refreshTokenExpirationMs / 1000);

        response.addCookie(cookie);

        return LoginResponse.builder()
                .message("User logged in successfully")
                .accessToken(accessToken)
                .build();
    }

    private String extractRefreshTokenFromCookie(HttpServletRequest request) {
        if (request.getCookies() == null) {
            return null;
        }

        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("refresh_token")) {
                return cookie.getValue();
            }
        }

        return null;
    }

    public RefreshResponse refresh(HttpServletRequest request) {
        String refreshToken = extractRefreshTokenFromCookie(request);

        if (refreshToken == null) {
            throw new CustomAuthenticationException("Missing refresh token");
        }

        if (!jwtUtil.isRefreshTokenValid(refreshToken)) {
            throw new CustomAuthenticationException("Invalid or expired refresh token");
        }

        String email = jwtUtil.extractUsername(refreshToken);

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        String newAccessToken = jwtUtil.generateAccessToken(user.getEmail());

        return new RefreshResponse(
                "Token refreshed successfully",
                newAccessToken
        );
    }


    public void logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("refresh_token", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(secureCookie);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }
}