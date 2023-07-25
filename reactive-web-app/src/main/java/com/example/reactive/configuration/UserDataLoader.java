package com.example.reactive.configuration;

import com.example.reactive.model.User;
import com.example.reactive.service.UserService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDataLoader {

    private final UserService userService;

    private final List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(User.builder().id(1L).name("Tomas").lastName("Clark").build());
        userList.add(User.builder().id(2L).name("Ed").lastName("Smart").build());
        userList.add(User.builder().id(3L).name("Kate").lastName("Bor").build());
        userList.add(User.builder().id(4L).name("Bob").lastName("Brown").build());
        userList.add(User.builder().id(5L).name("Rob").lastName("Black").build());
    }

    public UserDataLoader(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void dataLoader() {

        Flux.fromIterable(userList).flatMap(userService::addUser)
                .subscribe(System.out::println);
    }

}
