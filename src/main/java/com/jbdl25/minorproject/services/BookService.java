package com.jbdl25.minorproject.services;

import com.jbdl25.minorproject.model.Author;
import com.jbdl25.minorproject.model.Book;
import com.jbdl25.minorproject.repositories.BookRepository;
import com.jbdl25.minorproject.requests.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    @Transactional
    public void addBook(BookCreateRequest bookCreateRequest) {
        Book book = bookCreateRequest.toBook();
        Author author = authorService.getAuthorByEmail(bookCreateRequest.getEmail());

        if (author == null) {
            author = Author.builder()
                    .name(bookCreateRequest.getAuthorName())
                    .country(bookCreateRequest.getCountry())
                    .email(bookCreateRequest.getEmail())
                    .build();

            authorService.addAuthor(author);
        }

        book.setAuthor(author);

        bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void addOrUpdateBook(Book book) {
        bookRepository.save(book);
    }
}
