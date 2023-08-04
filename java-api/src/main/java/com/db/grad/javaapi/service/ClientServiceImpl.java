package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Client;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.ClientRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;
    private final TradeRepository tradeRepository;

    @Autowired
    public ClientServiceImpl(final ClientRepository clientRepository, BookRepository bookRepository, TradeRepository tradeRepository) {
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
        this.tradeRepository = tradeRepository;
    }

    public void initializeClientsPasswordHash() {
        List<Client> clients = clientRepository.findAll();

        for (Client client : clients) {
            client.setClientPasswordHash("defaultPassword"+client.getClientName());
            clientRepository.save(client);
        }
    }
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Book> getBooksByClientId(int clientId) {
        return bookRepository.findByClient_ClientId(clientId);
    }

    @Override
    public Client findByClientEmail(String email) {
        return clientRepository.findByClientEmail(email);
    }
}
