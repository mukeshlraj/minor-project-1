package com.jbdl25.minorproject.controllers;

import com.jbdl25.minorproject.model.Book;
import com.jbdl25.minorproject.requests.BookCreateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @PostMapping("/book")
    public void createBook(@RequestBody BookCreateRequest bookCreateRequest) {

    }

    @GetMapping("/book")
    public Book getBook(@RequestParam("id") int id) {
        return null;
    }
}
