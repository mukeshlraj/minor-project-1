package com.jbdl25.minorproject.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @PostMapping("/issue_book")
    public String issueBook(@RequestParam("book_id") int bookId, @RequestParam("student_id") int studentId) {
        return null;
    }

    @PostMapping("/return_book")
    public String  returnBook(@RequestParam("book_id") int bookId, @RequestParam("student_id") int studentId, @RequestParam("fine") int fine){
        return null;
    }

}
