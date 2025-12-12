package com.example.demo.dao;

import com.example.demo.entity.Category;

public interface AppDAO {
    void save(Category category);
    Category findCategoryById(int theId);
    void deleteCategorybyId(int theId);
//    Category findCategoryDetailById(int theId);
//    void deleteCategoryDetailById(int theId);
}
