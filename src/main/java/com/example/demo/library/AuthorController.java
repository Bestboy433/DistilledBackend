package com.example.demo.library;

//Api layer containing all resources needed for the Api

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/library")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired //dependency injection
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //To get full list of authors
    @GetMapping(path = "/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    //To add authors
    @PostMapping(path = "/addAuthor")
    public void addAuthor(Author author){
        authorService.addAuthor(author);
    }
}
