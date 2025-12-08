package com.example.demo.service;

import com.example.demo.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findAll();

    List<Authority> findByUsername(String username);

    Authority save(Authority authority);

    void deleteById(int id);

    Authority findById(int id);
}
