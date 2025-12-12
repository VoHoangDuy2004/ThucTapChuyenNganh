package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
    List<Product> findAllByStatus(String status);
    List<Product>findByCategoryId(int id_cate);
}
