package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findByIsin(String isin);

    @Query("SELECT b FROM Book b WHERE b.bookMaturityDate >= ?1 AND b.bookMaturityDate <= ?2")
    List<Book> findByBookMaturityDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT b.cusip FROM Book b WHERE b.isin = :isin")
    String findCUSIPByISIN(@Param("isin") String isin);

    @Query("SELECT b.issuerName FROM Book b WHERE b.isin = :isin")
    String findIssuerByISIN(@Param("isin") String isin);

    @Query("SELECT t.bookHolder FROM Trade t WHERE t.isin = :isin")
    List<String> findDistinctBookHoldersByISIN(@Param("isin") String isin);

    @Query("SELECT b FROM Book b WHERE b.client.client_id = :clientId")
    List<Book> findByClient_ClientId(int clientId);

}