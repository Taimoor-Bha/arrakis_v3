package com.db.grad.javaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PasswordUpdateRunner implements CommandLineRunner {
    private final ClientServiceImpl clientServiceImpl;

    @Autowired
    public PasswordUpdateRunner(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        clientServiceImpl.initializeClientsPasswordHash();
    }
}