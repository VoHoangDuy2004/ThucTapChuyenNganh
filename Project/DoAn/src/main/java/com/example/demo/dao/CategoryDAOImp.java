package com.example.demo.dao;

import com.example.demo.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO {
    private EntityManager em;
    @Autowired
    public CategoryDAOImp(EntityManager em){
        this.em=em;
    }
    @Override
    public List<Category> findAll() {
        TypedQuery<Category>query=em.createQuery("from Category",Category.class);
        return query.getResultList();
    }

    @Override
    public Category findById(int id) {
        return em.find(Category.class, id);
    }

    @Override
    public Category save(Category category) {
        return em.merge(category);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Category category = findById(id);
        em.remove(category);
    }
    @Override
    public List<Category> findAllByStatus(String status) {
        TypedQuery<Category> query = em.createQuery(
                "from Category c where c.status = :status", Category.class
        );
        query.setParameter("status", status);
        return query.getResultList();
    }
}
