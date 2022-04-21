package com.example.demo.library;

//Api layer containing all resources needed for the Api

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/library")
public class BookController {

    private final BookService bookService;

    @Autowired //dependency injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //Full list of books
    @GetMapping(path = "/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    // Get book by ISBN
    @GetMapping(path = "/books/isbn={isbn}")
    public List<Book> getBookByISBN(@PathVariable("isbn") Long isbn){
        return bookService.getBookByISBN(isbn);
    }
    // Get book by Title
    @GetMapping(path = "/books/title={title}")
    public List<Book> getBookByTitle(@PathVariable("title") String title){
        return bookService.getBookByTitle(title);
    }
    // Get book by Author
    @GetMapping(path = "/books/author={name}")
    public List<Book> getBookByAuthor(@PathVariable("name") String name){
        return bookService.getBookByAuthor(name);
    }

    //add a new book to the library
    @PostMapping(path = "/newBook")
    public void addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    //delete a book from the library
    @DeleteMapping(path = "/deleteBook/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
    }
}
