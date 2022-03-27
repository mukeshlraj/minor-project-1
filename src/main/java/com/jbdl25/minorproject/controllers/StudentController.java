package com.jbdl25.minorproject.controllers;

import com.jbdl25.minorproject.model.Student;
import com.jbdl25.minorproject.model.User;
import com.jbdl25.minorproject.requests.StudentCreateRequest;
import com.jbdl25.minorproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void addStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        studentService.addStudent(studentCreateRequest);
    }

    //student
    @GetMapping("/student")
    public Student getStudent() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        String  studentId = user.getUsername();
        return studentService.getStudent(studentId);
    }

    // admin
    @GetMapping("/student/id")
    public Student getStudentById(@RequestParam("id") String id) {
        return studentService.getStudent(id);
    }

}
