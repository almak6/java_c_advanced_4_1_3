package com.example.creationbookservice;

import com.example.creationbookservice.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class CreationBookServiceApplication {

    @Bean
    public Supplier<Book> bookPublishing() {
        return () -> new Book.Builder()
                .setId(1L)
                .setName("Coach")
                .setDescription("This book is about a great coach")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CreationBookServiceApplication.class, args);
    }
}
