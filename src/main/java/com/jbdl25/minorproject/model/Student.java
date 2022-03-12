package com.jbdl25.minorproject.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    private int age;

    @Column(unique = true, nullable = false)
    private String contact;

    @CreationTimestamp
    private Date registeredOn;

    @OneToMany
    private List<Book> books;

    private int totalFine;
}
