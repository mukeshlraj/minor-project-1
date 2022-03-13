package com.jbdl25.minorproject.repositories;

import com.jbdl25.minorproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("from Author where email= :email")
    Author findByEmail(String email);
}
