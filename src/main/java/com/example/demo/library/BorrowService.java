package com.example.demo.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Tells java that this is a Spring Bean
public class BorrowService {

    private final BorrowRepository borrowRepository;


    @Autowired //dependency injection again
    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }


    public List<Borrow> getBorrows() {
        return borrowRepository.findAll();
    }

    public void addBorrow(Borrow borrow) {
        Optional<Borrow> borrowOptional1 = borrowRepository.findBorrowByBid(borrow.getId());


        if(borrowOptional1.isPresent()){
            throw new IllegalStateException("ID taken");
        }
        else{

            borrowRepository.save(borrow);
        }
    }
}
