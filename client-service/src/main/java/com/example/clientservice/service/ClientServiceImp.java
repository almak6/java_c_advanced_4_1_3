package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImp implements ClientService {

    private BookServiceConnector bookServiceConnector;

    @Override
    public List<Book> getAllBooks() {
        return bookServiceConnector.getAllBooks();
    }
}
