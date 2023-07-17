package com.example.checkbookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {

    private Long id;
    private String name;
    private String description;
    private String status;

}
