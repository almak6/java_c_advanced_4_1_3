package com.example.testreactive;

import com.example.testreactive.client.UserWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestReactiveApp {

    public static void main(String[] args) {
        SpringApplication.run(TestReactiveApp.class, args);

        UserWebClient webClient = new UserWebClient();
        webClient.getAllUsersAndLastUserOfList();
    }
}
