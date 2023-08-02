package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getSecurities() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    public Book modifyBook(long id) {
        Book book = new Book();
        book.setBookId(id);
        return bookRepository.save(book);
    }




}
