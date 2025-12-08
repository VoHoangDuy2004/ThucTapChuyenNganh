package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User users);

    User findByUsername(String username);

    void deleteByUsername(String username);
}
