package com.kj.dashboardapi.controllers;

import com.kj.dashboardapi.configs.JwtTokenProvider;
import com.kj.dashboardapi.models.User;
import com.kj.dashboardapi.repositories.UserRepository;
import com.kj.dashboardapi.services.impl.MongoUserService;
import com.kj.dashboardapi.utils.models.AuthBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoUserService mongoUserService;

    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthBody data) {
        String username = data.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
        String token = jwtTokenProvider.createToken(username, this.userRepository.findByUsername(username).getRoles());
        Map<Object, Object> model = new HashMap<>();
        model.put("username", username);
        model.put("token", token);
        return ResponseEntity.ok(model);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<Object, Object>> register(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser != null) {
            throw new BadCredentialsException("User with this username already exists");
        }

        userRepository.save(user);

        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ResponseEntity.ok(model);
    }
}
