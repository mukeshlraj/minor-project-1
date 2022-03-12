package com.jbdl25.minorproject.controllers;

import com.jbdl25.minorproject.model.Student;
import com.jbdl25.minorproject.requests.StudentCreateRequest;
import com.jbdl25.minorproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void addStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        studentService.addStudent(studentCreateRequest);
    }

    @GetMapping("/student")
    public Student getStudent(@RequestParam("id") int id) {
        return studentService.getStudent(id);
    }

}
