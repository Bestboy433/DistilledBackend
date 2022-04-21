package com.example.demo.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Tells java that this is a Spring Bean
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired //dependency injection again
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        //First, check if the author exists
        List<Author> aut = authorRepository.findAuthorByName(author.getName());
        if(!aut.isEmpty()){
            throw new IllegalStateException("The Author " +author.getName()+ " already exists");
        }
        authorRepository.save(author);
    }
}
