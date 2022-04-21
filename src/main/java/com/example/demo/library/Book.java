package com.example.demo.library;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(name = "id")
    private Long id;
    private int isbn;
    private String title;
    private String status;

    @OneToMany(targetEntity=Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name="ba_fk", referencedColumnName = "id")
    private List<Author> authors;

    //constructor
    public Book(){

    }
    public Book(Long id, int isbn, String title, String status, List<Author> authors) {
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
    public Long getId() {
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", authors=" + authors.toString() +
                '}';
    }
}
