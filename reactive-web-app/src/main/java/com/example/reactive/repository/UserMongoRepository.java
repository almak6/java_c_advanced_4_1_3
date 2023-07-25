package com.example.reactive.repository;

import com.example.reactive.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserMongoRepository extends ReactiveMongoRepository<User, Long> {

}
