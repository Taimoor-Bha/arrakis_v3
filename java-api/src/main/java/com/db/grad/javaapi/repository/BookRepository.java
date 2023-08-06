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
    List<Book> findBySpecifiedDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT b FROM Book b WHERE b.client.client_id = :clientId")
    List<Book> findBooksByClientId(int clientId);

    @Query("SELECT t.bookHolder FROM Trade t WHERE t.isin = :isin")
    List<String> findBookHoldersById(@Param("isin") String isin);

//    @Query("SELECT b.isin FROM Book b WHERE b.client_id = :client_id")
//    List<String> findByISIN(@Param("client_id") int client_id);
//
//    @Query("SELECT b.cusip FROM Book b WHERE b.client_id = :client_id")
//    List<String> findByCUSIP(@Param("client_id") int client_id);
}