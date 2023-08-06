package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Client;
import com.db.grad.javaapi.service.ClientServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;

    @Autowired
    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientServiceImpl.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        Optional<Client> client = clientServiceImpl.getClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/bonds")
    public ResponseEntity<List<Book>> getBooksByClientId(@PathVariable int id) {
        if (Objects.isNull(getClientById(id).getBody())) {
               return ResponseEntity.notFound().build();
        }
        List<Book> books = clientServiceImpl.getBooksByClientId(id);
        return ResponseEntity.ok(books);
    }


}