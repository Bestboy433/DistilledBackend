package com.example.demo.library;

//Api layer containing all resources needed for the Api

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/library")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired //dependency injection
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
}
