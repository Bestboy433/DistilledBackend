package com.example.demo.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This is the data service layer for the book object

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
