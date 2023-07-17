package com.example.storebookservice.service;

import com.example.storebookservice.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableBinding(Sink.class)
public class BookConsumer {

    private List<Book> listBooks = new ArrayList<>();

    @StreamListener(target = Processor.OUTPUT)
    public void handleBook(Book book) {
        listBooks.add(book);
    }
}
