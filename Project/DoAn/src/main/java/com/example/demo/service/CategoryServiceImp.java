package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.CategoryDAOImp;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService{

    private CategoryDAO categoryDAO;
    private final ProductDAO productDAO;

    public CategoryServiceImp(ProductDAO productDAO, CategoryDAO categoryDAO) {
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
    }

    @Autowired
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }


    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public List<Category> findAllByStatus(String status) {
        return categoryDAO.findAllByStatus(status);
    }
}
