package com.example.demo.library;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Author {
    //
    @Id
    @GeneratedValue
    @Column(name = "aid")
    private Long aid;
    private String name;

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
