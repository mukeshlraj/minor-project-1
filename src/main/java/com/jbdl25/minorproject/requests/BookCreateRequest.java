package com.jbdl25.minorproject.requests;

import com.jbdl25.minorproject.model.Book;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateRequest {
    private String name;
    private int cost;
    private String publisher;

    private String authorName;
    private String country;
    private String email;

    public Book toBook() {
        return Book.builder()
                .cost(cost)
                .name(name)
                .publisher(publisher)
                .isAvailable(true)
                .build();
    }
}
