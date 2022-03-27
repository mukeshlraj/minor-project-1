package com.jbdl25.minorproject.services;

import com.jbdl25.minorproject.model.Student;
import com.jbdl25.minorproject.model.User;
import com.jbdl25.minorproject.repositories.StudentRepository;
import com.jbdl25.minorproject.repositories.UserRepository;
import com.jbdl25.minorproject.requests.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${app.security.student_role}")
    String STUDENT_ROLE;

    @Transactional
    public void addStudent(StudentCreateRequest studentCreateRequest){
        Student student = studentCreateRequest.toStudent();
        studentRepository.save(student);

        User user = User.builder()
                .username(studentCreateRequest.getEmail())
                .password(passwordEncoder.encode(studentCreateRequest.getPassword()))
                .authorities(STUDENT_ROLE)
                .build();

        userRepository.save(user);
    }

    public Student getStudent(String id) {
        return studentRepository.findByEmail(id);
    }
}
