package com.example.checkbookservice.service;

import com.example.checkbookservice.model.Book;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;


@Service
@EnableBinding(Processor.class)
@MessageEndpoint
public class BookProcessor {

    @StreamListener(target = Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Book handleBook(Book book) throws Exception {
        book.setStatus("checked");
        return book;
    }
}
