package com.jbdl25.minorproject.controllers;

import com.jbdl25.minorproject.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue_book")
    public String issueBook(@RequestParam("book_id") int bookId, @RequestParam("student_id") int studentId) throws Exception{
        return transactionService.issueBook(bookId,studentId);
    }

    @PostMapping("/return_book")
    public String  returnBook(@RequestParam("book_id") int bookId, @RequestParam("student_id") int studentId) throws Exception {
        return transactionService.returnBook(bookId,studentId);
    }

}
