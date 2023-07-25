package com.example.reactive.controller;

import com.example.reactive.model.User;
import com.example.reactive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserReactiveController {

    private final UserService userService;

    @GetMapping
    public Flux<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public Mono<User> showUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
