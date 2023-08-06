package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByClientEmail(String ClientEmail);

//    @Query("SELECT b.isin FROM Book b WHERE b.client_id = :client_id")
//    List<String> findByISIN(@Param("client_id") int client_id);

//    @Query("SELECT b.cusip FROM Book b WHERE b.client_id = :client_id")
//    List<Book> findByCUSIP(@Param("client_id") int client_id);
}
