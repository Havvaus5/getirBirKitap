package com.getir.demo.repository;

import com.getir.demo.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query("update Book b set b.stockQuantity= :stockQuantity where id= :bookId")
    void updateStock(@Param("bookId") Long bookId, @Param("stockQuantity") int stockQuantity);
}
