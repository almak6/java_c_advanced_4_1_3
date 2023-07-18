package com.example.storebookservice;

import com.example.storebookservice.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class StoreBookServiceApplication {

    @Bean
    public Consumer<Book> bookSubscribing() {
        return book -> System.out.println(book);
    }
    public static void main(String[] args) {
        SpringApplication.run(StoreBookServiceApplication.class, args);
    }
}

