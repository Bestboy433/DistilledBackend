package com.example.demo.library;

//Api layer containing all resources needed for the Api

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/library")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired //dependency injection
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    //To get full list of borrows
    @GetMapping(path = "/borrows")
    public List<Borrow> getBorrows(){
        return borrowService.getBorrows();
    }

    //Register a borrow
    @PostMapping(path = "/newBorrow")
    public void addBorrow(@RequestBody Borrow borrow){
        borrowService.addBorrow(borrow);
    }

}
