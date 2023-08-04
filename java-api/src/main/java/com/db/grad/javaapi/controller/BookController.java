package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    @Autowired
    public BookController(final BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookServiceImpl.getAllActiveBooks();
    }

    @GetMapping("/{isin}")
    public ResponseEntity<?> getBookByIsin(@PathVariable String isin) {
        Optional<Book> book = bookServiceImpl.findByIsin(isin);
        if (book.isPresent()){
            return ResponseEntity.ok(book);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ISIN " + isin + " not found");
    }

    @GetMapping("/maturity")
    public ResponseEntity<List<Book>> getBooksDueForMaturityInLastAndNextFiveDays() {
        List<Book> books = bookServiceImpl.findBooksDueForMaturityInLastAndNextFiveDays();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }

    @PostMapping("/maturity/date")
    public ResponseEntity<List<Book>> getBooksDueForMaturityInLastAndNextFiveDaysByDate(@RequestParam String dateStr) {
        List<Book> books = bookServiceImpl.findBooksDueForMaturityInLastAndNextFiveDaysByDate(dateStr);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }

    @PostMapping("/maturity/workday/date")
    public ResponseEntity<List<Book>> getBooksDueForMaturityInLastAndNextFiveWorkDaysByDate(@RequestParam String dateStr) {
        List<Book> books = bookServiceImpl.findBooksDueForMaturityInLastAndNextFiveWorkDaysByDate(dateStr);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }

    @GetMapping("/issuers")
    public ResponseEntity<Map<String, String>> getBookIsinIssuerMap() {
        Map<String, String> bookIsinIssuerMap = bookServiceImpl.getBookIsinIssuerMap();

        if (!bookIsinIssuerMap.isEmpty()) {
            return ResponseEntity.ok(bookIsinIssuerMap);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
