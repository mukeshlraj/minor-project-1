package com.jbdl25.minorproject.services;

import com.jbdl25.minorproject.model.Student;
import com.jbdl25.minorproject.repositories.StudentRepository;
import com.jbdl25.minorproject.requests.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(StudentCreateRequest studentCreateRequest){
        Student student = studentCreateRequest.toStudent();
        studentRepository.save(student);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
