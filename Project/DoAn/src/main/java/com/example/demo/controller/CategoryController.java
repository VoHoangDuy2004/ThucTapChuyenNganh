package com.example.demo.controller;

import com.example.demo.dao.CategoryDAOImp;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category-list")
    public String list(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/category";
    }
}