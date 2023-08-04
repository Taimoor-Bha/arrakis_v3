package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByClientEmail(String ClientEmail);

}
