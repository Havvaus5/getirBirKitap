package com.getir.demo.repository;

import com.getir.demo.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "select * from GETIR.STOCK where BOOK_ID = :bookId", nativeQuery = true)
    Optional<Stock> findByBookId(@Param("bookId") Long bookId);
}
