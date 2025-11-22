package com.example.letsreviewserver.auth;

import com.example.letsreviewserver.dto.LoginRequest;
import com.example.letsreviewserver.dto.LoginResponse;
import com.example.letsreviewserver.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        String message;
        try {
            message = authService.register(registerRequest);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            message = e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest,
            HttpServletResponse response
    ) {
        LoginResponse loginResponse;
        try {
            loginResponse = authService.login(loginRequest, response);
            return ResponseEntity.ok(loginResponse);
        } catch (AuthenticationException e) {
            loginResponse = new LoginResponse();
            loginResponse.setAccessToken("Bad credentials");
            return ResponseEntity.badRequest().body(loginResponse);
        }
    }
}
