package com.jbdl25.minorproject.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Author author;

    @ManyToOne
    private Student student;
    private String publisher;
    private int cost;
    private boolean isAvailable;

    @CreationTimestamp
    private Date addedOn;
}
