package com.example.letsreviewserver.auth;

import com.example.letsreviewserver.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping("/login")
//    public ResponseEntity<AuthResponse> login(
//            @RequestBody LoginRequest loginRequest
//    ) {
//        return ResponseEntity.ok(authService.login(loginRequest));
//    }
}
