package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User save(User users);

    User findByUsername(String username);

    void deleteByUsername(String username);
}
