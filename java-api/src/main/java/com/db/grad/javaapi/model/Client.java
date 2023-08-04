package com.db.grad.javaapi.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_surname")
    private String clientSurname;

    @Column(name = "client_email")
    private String clientEmail;

    @Column(name = "client_department")
    private String clientDepartment;

    @Column(name = "client_role")
    private String clientRole;

    @Column(name = "client_password_hash")
    private String clientPasswordHash;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Book> books;

    public void setClientPasswordHash(String clientPasswordHash) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.clientPasswordHash = passwordEncoder.encode(clientPasswordHash);
    }
}