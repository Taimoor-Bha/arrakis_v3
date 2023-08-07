package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isin;

    @Column(name = "book_currency")
    private String bookCurrency;

    private String cusip;

    @Column(name = "face_value")
    private int faceValue;

    @Column(name = "issuer_name")
    private String issuerName;

    @Column(name = "book_maturity_date")
    private Date bookMaturityDate;

    private String status;

    private String type;

    @Column(name = "client_id")
    private int clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Trade> trades;
}
