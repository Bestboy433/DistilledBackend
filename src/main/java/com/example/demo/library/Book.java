package com.example.demo.library;

import java.util.List;

public class Book {

    private int id;
    private int isbn;
    private String title;
    private String status;
    private List<Author> authors;

    //constructor
    public Book(){

    }
    public Book(int id, int isbn, String title, String status, List<Author> authors) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.status = status;
        this.authors = authors;
    }
    public Book(int isbn, String title, String status, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.status = status;
        this.authors = authors;
    }
    public Book(int isbn, String title, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

    //getters
    public int getId() {
        return id;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    //setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void removeAuthor(Author author){
        authors.remove(author);
    }
}
