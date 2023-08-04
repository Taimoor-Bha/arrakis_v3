package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/")
    public Book addBook(@Valid @RequestBody Book book) {

        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable(value = "id") long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/")
    public Book modifyBook(@Valid @RequestBody Book book) {
        return bookService.modifyBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(value = "id") long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}/trades")
    public Set<Trade> getTrades(long id) {
        return bookService.getTrades(id);
    }

    @GetMapping("/bondholders")
    public Set<Users> getBondHoldersList(long id) {
        return bookService.getBondHoldersList(id);
    }

    @GetMapping("/issuers")
    public Set<Users> getIssuersList(long id) {
        return bookService.getIssuersList(id);
    }

}
