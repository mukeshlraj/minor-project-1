package com.jbdl25.minorproject.controllers;

import com.jbdl25.minorproject.model.Book;
import com.jbdl25.minorproject.requests.BookCreateRequest;
import com.jbdl25.minorproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@RequestBody BookCreateRequest bookCreateRequest) {
        bookService.addBook(bookCreateRequest);
    }

    @GetMapping("/book")
    public Book getBook(@RequestParam("id") int id) {
        return bookService.getBookById(id);
    }
}
