package com.casa.controller;

import com.casa.dto.LoginRequest;
import com.casa.dto.RegisterRequest;
import com.casa.model.User;
import com.casa.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        try {
            User u = service.register(req);
            u.setPassword(null);
            return ResponseEntity.ok(u);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        User u = service.login(req);
        if (u == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        u.setPassword(null);
        return ResponseEntity.ok(u);
    }
}
