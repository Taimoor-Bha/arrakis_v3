package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllActiveBooks() {

        return bookRepository.findAll();
    }


    @Override
    public List<Book> findBooksMaturingBetweenLastAndNextDays(String givenDate) {
        DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();

        try {
            LocalDate utilDate = LocalDate.parse(givenDate, inputDateFormat);
            currentDate = utilDate;
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Book> books = new ArrayList<>();

        // Find previous five working days
        LocalDate lastFiveDays = currentDate;
        int daysToSubtract = 0;
        while (daysToSubtract < 5) {
            lastFiveDays = lastFiveDays.minusDays(1);
            if (isWorkingDay(lastFiveDays)) {
                daysToSubtract++;
            }
        }

        // Find next five working days
        LocalDate nextFiveDays = currentDate;
        int daysToAdd = 0;
        while (daysToAdd < 5) {
            nextFiveDays = nextFiveDays.plusDays(1);
            if (isWorkingDay(nextFiveDays)) {
                daysToAdd++;
            }
        }

        return bookRepository.findBySpecifiedDates(java.sql.Date.valueOf(lastFiveDays), java.sql.Date.valueOf(nextFiveDays));
    }

    // Helper method to check if a given date is a working day (excluding weekends)
    private boolean isWorkingDay(LocalDate date) {
        return date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }


    @Override
    public Optional<Book> findByIsin(String isin) {
        return bookRepository.findByIsin(isin);
    }

    @Override
    public Map<String, String> getBookIsinIssuerMap() {
        List<Book> books = bookRepository.findAll();
        return books.stream().collect(Collectors.toMap(Book::getIsin, Book::getIssuerName));
    }
}
