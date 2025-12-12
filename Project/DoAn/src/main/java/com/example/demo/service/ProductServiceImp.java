package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductServiceImp implements ProductService {
    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImp(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void deleteById(int id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> findAllByStatus(String status) {
        return productDAO.findAllByStatus(status);
    }

    @Override
    public List<Product> findByCategoryId(int id_cate) {
        return productDAO.findByCategoryId(id_cate);
    }
}