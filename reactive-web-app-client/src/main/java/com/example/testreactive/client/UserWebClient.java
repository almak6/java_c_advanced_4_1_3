package com.example.testreactive.client;

import com.example.testreactive.model.User;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class UserWebClient {

    private final WebClient webClient;

    public UserWebClient() {
        this.webClient = WebClient.create("http://localhost:8070/api");;
    }

    public Flux<User> getAllUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class)
                .doOnNext(user -> System.out.println("Received user: " + user));
    }

    public Mono<User> getUserById(Long id) {
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class)
                .doOnNext(System.out::println);
    }

    public void getAllUsersAndLastUserOfList() {
        getAllUsers().last().zipWith(getUserById(5L), Object::equals)
                .subscribe(match -> System.out.println("Users match? " + match));
    }
}
