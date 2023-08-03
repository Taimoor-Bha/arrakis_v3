package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "book_id")
    private Long bookId;

    public void setTradesList(Set<Trade> tradesList) {
        this.tradesList = tradesList;
    }

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Trade> tradesList;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_user",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Users> usersList;
    private String name;

    public Book() {}

    public Long getBook_id() {
        return bookId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Set<Trade> getTradesList() {
        return tradesList;
    }
    public Set<Users> getUsersList() {
        return usersList;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String BookName) {
        this.name = BookName;
    }
}
