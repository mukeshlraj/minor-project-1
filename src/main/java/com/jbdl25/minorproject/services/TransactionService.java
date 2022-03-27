package com.jbdl25.minorproject.services;

import com.jbdl25.minorproject.model.*;
import com.jbdl25.minorproject.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public String issueBook(int bookId, String studentId) throws Exception {
        Book book = bookService.getBookById(bookId);

        if (book == null || !book.isAvailable())
            return "Book is not available";

        Student student = studentService.getStudent(studentId);

        if (student == null)
            return "Student not found";

        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDING)
                .transactionType(TransactionType.ISSUE)
                .student(student)
                .book(book)
                .build();

        try {
            transactionRepository.save(transaction);
            book.setAvailable(false);
            book.setStudent(student);
            bookService.addOrUpdateBook(book);

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transactionRepository.save(transaction);
        }
        catch (Exception exception) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Transaction : " + transaction.getTransactionId() + " has failed.");
        }

        return transaction.getTransactionId();
    }

    public int getFine(int bookId, int studentId) {
        return 0;
    }

//    @Transactional
//    public String returnBook(int bookId, int studentId) throws Exception {
//        Book book = bookService.getBookById(bookId);
//
//        if (book == null || book.isAvailable())
//            return "Book is not found or book is not issued to anyone";
//
//        Student student = studentService.getStudent(studentId);
//
//        if (student == null || book.getStudent().getId() != studentId)
//            return "Student not found or book is not issued to this student";
//
//        Transaction transaction = Transaction.builder()
//                .transactionId(UUID.randomUUID().toString())
//                .transactionStatus(TransactionStatus.PENDING)
//                .transactionType(TransactionType.RETURN)
//                .student(student)
//                .book(book)
//                .build();
//
//        try {
//            transactionRepository.save(transaction);
//            book.setAvailable(true);
//            book.setStudent(null);
//            bookService.addOrUpdateBook(book);
//
//            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
//            transactionRepository.save(transaction);
//        }
//        catch (Exception exception) {
//            transaction.setTransactionStatus(TransactionStatus.FAILED);
//            transactionRepository.save(transaction);
//            book.setAvailable(false);
//            book.setStudent(student);
//            bookService.addOrUpdateBook(book);
//            throw new Exception("Transaction : " + transaction.getTransactionId() + " has failed.");
//        }
//        return transaction.getTransactionId();
//    }
}
