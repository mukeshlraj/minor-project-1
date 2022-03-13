package com.jbdl25.minorproject.services;

import com.jbdl25.minorproject.model.Author;
import com.jbdl25.minorproject.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author getAuthorByEmail(String email) {
        return authorRepository.findByEmail(email);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
}
