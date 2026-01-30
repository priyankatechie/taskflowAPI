package com.taskflow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskflow.Dto.LoginRequest;
import com.taskflow.Dto.RegisterRequest;
import com.taskflow.Entity.User;
import com.taskflow.Repository.UserRepository;
import com.taskflow.Security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
@Autowired
    private  UserRepository userRepo;
@Autowired
    private  PasswordEncoder encoder;
@Autowired
    private  JwtUtil jwtUtil;
    
    
    
    

    public AuthService(UserRepository userRepo, PasswordEncoder encoder, JwtUtil jwtUtil) {
		this.userRepo = userRepo;
		this.encoder = encoder;
		this.jwtUtil = jwtUtil;
	}

	public User register(RegisterRequest req) {
        if (userRepo.findByEmail(req.getEmail()).isPresent())
            throw new RuntimeException("Email already exists");

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));

        return userRepo.save(user);
    }

    public String login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!encoder.matches(req.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid credentials");

        return jwtUtil.generateToken(user.getEmail());
    }
}
