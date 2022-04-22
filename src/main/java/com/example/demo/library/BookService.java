package com.example.demo.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
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

    @Transactional
    public void deleteBook(Long bookId) {
        Boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        else{
            bookRepository.deleteBookById(bookId);
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

    public void addNewBorrow(Long id, String username) {
        //Check if the book exists, then create a borrow object
        Boolean exists = bookRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException("A book with id: " +id+ " does not exist");
        }
        else{
            Borrow borrow1 = new Borrow(bookRepository.getById(id), username);
        }
    }

    @Transactional
    public void updateStatus(Book book) {
        //update book status
        Book backup = book;
        deleteBook(book.getId());
        if(backup.getStatus().equals("Available")){
            backup.setStatus("Borrowed");
        }else{
            backup.setStatus("Available");
        }
        bookRepository.save(backup);
        System.out.println(backup);

    }

    public Book getBookById(Long bookID) {
        Boolean exists = bookRepository.existsById(bookID);
        if(!exists){
            throw new IllegalStateException("The book with id "+bookID+" does not exist and cannot be borrowed.");
        }
        return bookRepository.getBookById(bookID);
    }
}
