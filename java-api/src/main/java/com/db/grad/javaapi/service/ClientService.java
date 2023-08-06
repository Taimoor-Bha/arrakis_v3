package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getAllClients();

    Optional<Client> getClientById(int id);

    List<Book> getBooksByClientId(int clientId);

    Client findByClientEmail(String email);


}
