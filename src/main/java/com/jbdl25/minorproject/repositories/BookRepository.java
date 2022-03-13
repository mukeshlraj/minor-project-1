package com.jbdl25.minorproject.repositories;

import com.jbdl25.minorproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
