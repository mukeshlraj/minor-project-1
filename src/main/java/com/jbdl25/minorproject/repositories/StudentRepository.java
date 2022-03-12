package com.jbdl25.minorproject.repositories;

import com.jbdl25.minorproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
