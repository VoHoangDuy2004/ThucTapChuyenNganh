package com.example.demo.dao;

import com.example.demo.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImp implements  AppDAO{
    private EntityManager em;

    public AppDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Category thCategory){
        em.persist(thCategory);
    }

    @Override
    public Category findCategoryById(int theId) {
        return em.find(Category.class,theId);
    }

    @Override
    @Transactional
    public void deleteCategorybyId(int theId){
        Category temCategory=findCategoryById(theId);
        em.remove(temCategory);
    }

//    @Override
//    public Category findCategoryDetailById(int theId) {
//        return em.find(Category.class,theId);
//    }
//
//    @Override
//    @Transactional
//    public void deleteCategoryDetailById(int theId){
////        Category temCategory=findCategoryDetailById(theId);
////        em.remove(temCategory);
//        em.remove(findCategoryDetailById(theId));
//    }
}
