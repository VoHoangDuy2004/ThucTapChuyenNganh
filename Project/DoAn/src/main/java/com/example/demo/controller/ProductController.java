package com.example.demo.controller;

import com.example.demo.dao.CategoryDAOImp;
import com.example.demo.dao.ProductDAOImp;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/product-list")
    public String list(Model model) {
        List<Product> products = productService.findAll();
        List<Category>categories=categoryService.findAll();
        Map<Integer, String> cateMap = new HashMap<>();
        for (Category c : categories) {
            cateMap.put(c.getId(), c.getTitle());
        }
        for (Product p : products) {
            String tenDanhMuc = cateMap.get(p.getId_cate());
            p.setCategoryTitle(tenDanhMuc != null ? tenDanhMuc : "Chưa xác định");
        }
        model.addAttribute("products", products);
        return "admin/product";
    }
}