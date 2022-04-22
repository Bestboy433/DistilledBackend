package com.example.demo.library;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Borrow{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bid;

    private Long BookID;
    private String username;
    private LocalDate DateTime;


    public Borrow(Book book, String username){
        this.BookID = book.getId();
        this.username = username;
        DateTime = LocalDate.now();
        book.setStatus("Borrowed");
    }


    public Borrow(){}

    //setters and getters

    public Long getId() {
        return bid;
    }

    public void setId(Long bid) {
        this.bid = bid;
    }

    public Long getBookID() {
        return BookID;
    }

    public void setBookID(Long bookID) {
        BookID = bookID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDateTime() {
        return DateTime;
    }


    @Override
    public String toString() {
        return "Borrow{" +
                "bid=" + bid +
                ", BookID=" + BookID +
                ", username='" + username + '\'' +
                ", DateTime=" + DateTime +
                '}';
    }
}
