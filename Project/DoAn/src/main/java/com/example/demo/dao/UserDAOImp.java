package com.example.demo.dao;

import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{
    private final EntityManager em;
    @Autowired

    public UserDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User>query=em.createQuery("from User", User.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public User save(User users) {
        return em.merge(users);
    }

    @Override
    public User findByUsername(String username) {
        return em.find(User.class, username);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        User users = findByUsername(username);
        em.remove(users);
    }
}
