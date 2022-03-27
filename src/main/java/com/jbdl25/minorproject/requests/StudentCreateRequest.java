package com.jbdl25.minorproject.requests;

import com.jbdl25.minorproject.model.Student;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {
    private String name;
    private int age;
    private String country;
    private String contact;
    private String email;
    private String password;

    public Student toStudent() {
        return Student.builder()
                .name(name)
                .age(age)
                .contact(contact)
                .country(country)
                .email(email)
                .password(password)
                .build();
    }
}
