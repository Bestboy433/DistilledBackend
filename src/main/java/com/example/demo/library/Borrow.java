package com.example.demo.library;

import java.time.LocalDate;

public class Borrow extends Book{

    private Long id;
    private Long BookID;
    private String username;
    private LocalDate DateTime;

    public Borrow(Book book, String username){
        this.BookID = book.getId();
        this.username = username;
        DateTime = LocalDate.now();
    }

}
