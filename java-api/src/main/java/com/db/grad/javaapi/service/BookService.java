package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    // book name? - > Check in the controller!!!
    public Book modifyBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    // Wait for Rares
    public Set<Trade> getTrades(long id) {
        return Objects.requireNonNull(bookRepository.findById(id).orElse(null)).getTradesList();

    }

    // Still needs to be done
    public List<Book> getFilteredBooks(List<Date> dateList) {
        List<Book> allBooks = bookRepository.findAll();
        List<Book> filteredBooks = new ArrayList<Book>();

        for (Book book: allBooks) {
            Set<Trade> trades = book.getTradesList();
            List<Trade> filteredTrades = new ArrayList<Trade>();
            for (Trade trade : trades) {
                if (trade.getTrade_settlement_date().after(dateList.get(0))
                            && trade.getBond_maturity_date().before(dateList.get(1))){
                    filteredTrades.add(trade);
                    filteredBooks.add(book);
                }
            }
        }

        return filteredBooks;
    }

    public Set<Users> getUsersList(long id) {
        return Objects.requireNonNull(bookRepository.findById(id).orElse(null)).getUsersList();
    }


}
