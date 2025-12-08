package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"", "/", "/category-list"})
    public String list(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/category/category";
    }

    @GetMapping("/category-add-form")

    public String viewAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category/category-add-form";
    }

    @Transactional
    @PostMapping("/category-add-form")
    public String save(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/category/category-list";
    }

    @GetMapping("/category-edit-form")
    public String editForm(@RequestParam("id") int id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return "redirect:/admin/category/category-list";
        }
        model.addAttribute("category", category);
        return "admin/category/category-edit-form";
    }

    @Transactional
    @PostMapping("/category-edit-form")
    public String update(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/category/category-list";
    }

    @GetMapping("/category-delete-form")
    public String viewDelete(@RequestParam("id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/category-delete-form";
    }

    @PostMapping("/category-delete-form")
    public String delete(@RequestParam("id") int id) {
        categoryService.deleteById(id);
        return "redirect:/admin/category/category-list";
    }
}