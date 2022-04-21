package com.example.demo.library;

//Api layer containing all resources needed for the Api

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/library")
public class BookController {

    private final BookService bookService;

    @Autowired //dependency injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }




    @GetMapping(path = "/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
}
