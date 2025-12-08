package com.example.demo.dao;

import com.example.demo.entity.Authority;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorityDAOImp implements AuthorityDAO{
    private EntityManager em;

    public AuthorityDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Authority> findAll() {
        TypedQuery<Authority> query = em.createQuery("select au from Authority au", Authority.class);
        return query.getResultList();
    }
    @Override
    public List<Authority> findByUsername(String username) {
        TypedQuery<Authority> query = em.createQuery("from Authority au where au.user.username = :username", Authority.class)
                .setParameter("username", username);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Authority save(Authority authority) {
        return em.merge(authority);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Authority authority = em.find(Authority.class, id);
        em.remove(authority);
    }

    @Override
    public Authority findById(int id) {
        return em.find(Authority.class, id);
    }

}
