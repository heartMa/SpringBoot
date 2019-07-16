package com.w3cjava.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.w3cjava.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
