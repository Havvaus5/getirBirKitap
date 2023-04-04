package com.getir.demo.repository;

import com.getir.demo.model.entity.Author;
import com.getir.demo.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
