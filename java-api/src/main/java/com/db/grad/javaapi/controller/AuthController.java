package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Client;
import com.db.grad.javaapi.model.LoginClient;
import com.db.grad.javaapi.service.ClientService;
import com.db.grad.javaapi.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final ClientServiceImpl clientServiceImpl;

    @Autowired
    public AuthController(ClientServiceImpl clientRepository) {
        this.clientServiceImpl = clientRepository;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginClient client) {
        Client existingUser = clientServiceImpl.findByClientEmail(client.getEmail());

        if (existingUser != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(client.getPassword(), existingUser.getClientPasswordHash())) {
                return ResponseEntity.ok("Login successful");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}