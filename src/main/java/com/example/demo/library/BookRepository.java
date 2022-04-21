package com.example.demo.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//This is the data service layer for the book object

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // findBookByISBN executes a SQL statement -> "SELECT * FROM book WHERE isbn = ?"
    List<Book> findBookByTitle(String title);
    Optional<Book> findBookById(Long id);

    //Search methods
    List<Book> findBookByIsbn(Long isbn);


    //This Query makes use of the author_book table very easily! It searches books by author name
    List<Book> findByAuthors_Name(String authorName);
}
