package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookService {

    List<Book> getAllActiveBooks();


    List<Book> findBooksMaturingBetweenLastAndNextDays(String givenDate);

    Optional<Book> findByIsin(String isin);

    Map<String, String> getBookIsinIssuerMap();

    List<Book> getByISIN(int clientId);

    List<Book> getByCUSIP(int clientId);

}
