package com.example.demo.service;

import com.example.demo.dao.AuthorityDAO;
import com.example.demo.entity.Authority;

import java.util.List;

public class AuthorityServiceImp implements AuthorityService{
    private final AuthorityDAO authorityDAO;

    public AuthorityServiceImp(AuthorityDAO authorityDAO) {
        this.authorityDAO = authorityDAO;
    }

    @Override
    public List<Authority> findAll() {
        return authorityDAO.findAll();
    }

    @Override
    public List<Authority> findByUsername(String username) {
        return authorityDAO.findByUsername(username);
    }

    @Override
    public Authority save(Authority authority) {
        return authorityDAO.save(authority);
    }

    @Override
    public void deleteById(int id) {
        authorityDAO.deleteById(id);
    }

    @Override
    public Authority findById(int id) {
        return authorityDAO.findById(id);
    }
}
