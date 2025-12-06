package com.casa.service;

import com.casa.dto.LoginRequest;
import com.casa.dto.RegisterRequest;
import com.casa.model.User;
import com.casa.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User register(RegisterRequest req) {
        if (userRepo.findByEmail(req.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        User u = new User();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword()); // NOTE: plain text for demo
        u.setRole(req.getRole());
        return userRepo.save(u);
    }

    public User login(LoginRequest req) {
        User u = userRepo.findByEmail(req.getEmail());
        if (u == null) return null;
        if (!u.getPassword().equals(req.getPassword())) return null;
        return u;
    }
}
