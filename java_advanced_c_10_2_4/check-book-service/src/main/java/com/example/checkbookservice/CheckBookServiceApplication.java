package com.example.checkbookservice;

import com.example.checkbookservice.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class CheckBookServiceApplication {

    @Bean
    public Function<Book, Book> bookProcessing() {
        return book -> {
            book.setStatus("checked");
            return book;
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(CheckBookServiceApplication.class, args);
    }
}
