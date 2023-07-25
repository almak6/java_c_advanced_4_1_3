package com.example.reactive.service;

import com.example.reactive.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> getAllUsers();

    Mono<User> getUserById(Long id);

    Mono<User> addUser(User user);
}
