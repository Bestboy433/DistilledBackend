package com.example.demo.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service //Tells java that this is a Spring Bean
public class BookService {

    private final BookRepository bookRepository;

    @Autowired //dependency injection again
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional1 = bookRepository.findBookById(book.getId());


        if(bookOptional1.isPresent()){
            throw new IllegalStateException("ID taken");
        }
        else{
            bookRepository.save(book);
        }

        System.out.println(book);
    }

    public void deleteBook(Long bookId) {
        Boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        else{
            bookRepository.deleteById(bookId);
        }
    }

    public List<Book> getBookByISBN(Long isbn) {
        //check if exists, then return it
        List<Book> option1 = bookRepository.findBookByIsbn(isbn);
        if(option1.isEmpty()){
            throw new IllegalStateException("The book with ISBN "+isbn+" does not exist");
        }
        return option1;
    }

    public List<Book> getBookByTitle(String title) {
        List<Book> options = bookRepository.findBookByTitle(title);
        if(options.isEmpty()){
            throw new IllegalStateException("The book with ISBN "+title+" does not exist");
        }
        return options;
    }

    public List<Book> getBookByAuthor(String name) {
        List<Book> options = bookRepository.findByAuthors_Name(name);
        if(options.isEmpty()){
            throw new IllegalStateException("Books written by '"+name+"' do not exist");
        }
        return options;
    }
}
