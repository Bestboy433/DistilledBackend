package com.example.demo.library;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    //
    @Id
    @GeneratedValue
    @Column(name = "aid")
    private Long aid;
    private String name;

    //list of books written by the author
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "authors")
    private List<Book> books;

    //constructor
    public Author(String name) {
        this.name = name;
    }

    public Author() {}

    //getter
    public String getName() {
        return name;
    }



    //setter
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return name;
    }
}
