package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public List<Book> findBooksDueForMaturityInLastAndNextFiveDays() {
        java.util.Date date = new java.util.Date();
        Date currentDate = new Date(date.getTime());
        // for testing purpose
//        String dateString = "2021-08-05";
//        Date currentDate = Date.valueOf(dateString);

        Date lastFiveDays = new Date(currentDate.getTime() - 5 * 24 * 60 * 60 * 1000); // 5 days ago
        Date nextFiveDays = new Date(currentDate.getTime() + 5 * 24 * 60 * 60 * 1000); // 5 days from now
        return bookRepository.findByBookMaturityDateBetween(lastFiveDays, nextFiveDays);
    }


    @Override
    public List<Book> findBooksDueForMaturityInLastAndNextFiveWorkDaysByDate(String givenDate) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(System.currentTimeMillis());

        try {
            java.util.Date utilDate = inputDateFormat.parse(givenDate);
            currentDate = new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        List<Book> books = new ArrayList<>();

        // Find previous five working days
        for (int i = 0; i < 5; i++) {
            do {
                calendar.add(Calendar.DAY_OF_WEEK, -1);
            } while (!isWorkingDay(calendar)); // Skip weekends
        }
        Date lastFiveDays = new Date(calendar.getTimeInMillis());

        calendar.setTime(currentDate);

        // Find next five working days
        for (int i = 0; i < 5; i++) {
            do {
                calendar.add(Calendar.DAY_OF_WEEK, 1);
            } while (!isWorkingDay(calendar)); // Skip weekends
        }
        Date nextFiveDays = new Date(calendar.getTimeInMillis());

        return bookRepository.findByBookMaturityDateBetween(lastFiveDays, nextFiveDays);
    }

    private boolean isWorkingDay(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY;
    }


    @Override
    public List<Book> findBooksDueForMaturityInLastAndNextFiveDaysByDate(String givenDate) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = inputDateFormat.parse(givenDate);
            Date currentDate = new Date(utilDate.getTime());
            Date lastFiveDays = new Date(currentDate.getTime() - 5 * 24 * 60 * 60 * 1000); // 5 days ago
            Date nextFiveDays = new Date(currentDate.getTime() + 5 * 24 * 60 * 60 * 1000); // 5 days from now
            return bookRepository.findByBookMaturityDateBetween(lastFiveDays, nextFiveDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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
