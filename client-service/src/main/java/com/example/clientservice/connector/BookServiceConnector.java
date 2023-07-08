package com.example.clientservice.connector;

import com.example.clientservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookServiceConnector {
    @GetMapping("/api/books")
    List<Book> getAllBooks();
}
