package com.example.demo.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration //Saving data to book table in database
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
            Author farruk = new Author("Farruk");
            Author jarrad = new Author("Jarrad");
            Author jk = new Author("J.K Rowling");


            Book h = new Book(2345L,
                    "Hobit",
                    "Available",
                    List.of(farruk,jarrad));

            Book hp = new Book(2365L,
                    "Harry Potter",
                    "Available",
                    List.of(jk,farruk));

            repository.saveAll(
                    List.of(h,hp)
            );
        };
    }
}
