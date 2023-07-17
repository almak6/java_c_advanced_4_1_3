package com.example.creationbookservice.service;

import com.example.creationbookservice.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class BookProducer {

    private final Source source;

    public BookProducer(Source source) {
        this.source = source;
    }

    @Scheduled(fixedRate = 10000)
    private void sendBooks() {
        Book book = new Book.Builder()
                .setId(1L)
                .setName("Coach")
                .setDescription("This book is about a great coach")
                .build();
        source.output().send(MessageBuilder.withPayload(book).build());
    }
}
