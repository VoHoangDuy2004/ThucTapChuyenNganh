package com.example.demo.dao;

import com.example.demo.entity.Authority;

import java.util.List;

public interface AuthorityDAO {
    List<Authority> findAll();

    List<Authority> findByUsername(String username);

    Authority save(Authority authority);

    void deleteById(int id);

    Authority findById(int id);
}
