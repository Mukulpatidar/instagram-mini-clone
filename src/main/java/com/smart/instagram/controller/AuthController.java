package com.smart.instagram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.instagram.model.User;
import com.smart.instagram.security.JwtUtil;
import com.smart.instagram.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST /api/auth/signup
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED); 
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        return userService.findByUsername(loginRequest.getUsername())
                .map(user -> {
                    String token = JwtUtil.generateToken(user.getUsername());
                    return ResponseEntity.ok(token);
                })
                .orElse(
                    ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body("Invalid credentials")
                );
    }
	
}
