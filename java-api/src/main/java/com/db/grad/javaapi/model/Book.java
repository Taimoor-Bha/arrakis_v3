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

    public Book() {

    }

    public Book(Long bookId, Set<Trade> tradesList, Set<Users> issuersList, Set<Users> bondHoldersList, String name) {
        this.bookId = bookId;
        this.tradesList = tradesList;
        this.issuersList = issuersList;
        this.bondHoldersList = bondHoldersList;
        this.name = name;
    }

    public void setTradesList(Set<Trade> tradesList) {
        this.tradesList = tradesList;
    }

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Trade> tradesList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "trades",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "issuer_id"))
    private Set<Users> issuersList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "trades",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "bond_holder_id"))
    private Set<Users> bondHoldersList;

    private String name;

    public Long getBook_id() {
        return bookId;
    }


    public Long getBookId() {
        return bookId;
    }

    public Set<Trade> getTradesList() {
        return tradesList;
    }

    public void setIssuersList(Set<Users> issuersList) {
        this.issuersList = issuersList;
    }

    public void setBondHoldersList(Set<Users> bondHoldersList) {
        this.bondHoldersList = bondHoldersList;
    }

    public Set<Users> getIssuersList() {
        return issuersList;
    }

    public Set<Users> getBondHoldersList() {
        return bondHoldersList;
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
