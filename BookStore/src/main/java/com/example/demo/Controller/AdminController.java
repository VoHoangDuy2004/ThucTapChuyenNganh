package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // TRANG CHỦ ADMIN: /admin → templates/admin.html
    @GetMapping
    public String admin(Model model) {
        model.addAttribute("title", "Chefer - Trang chủ Admin");
        return "admin"; // → templates/admin.html
    }

    // DANH SÁCH SINH VIÊN: /admin/student-list
    @GetMapping("/student-list")
    public String studentList(Model model) {
        model.addAttribute("title", "Chefer - Danh sách sinh viên");
        return "admin/student"; // → templates/admin/student.html
    }

    // DANH SÁCH DANH MỤC: /admin/category-list
    @GetMapping("/category-list")
    public String categoryList(Model model) {
        model.addAttribute("title", "Chefer - Danh sách danh mục");
        return "admin/category/category-list"; // → templates/admin/category/category-list.html
    }

    // DANH SÁCH SẢN PHẨM: /admin/products-list
    @GetMapping("/products-list")
    public String productsList(Model model) {
        model.addAttribute("title", "Chefer - Danh sách sản phẩm");
        return "admin/products/products-list"; // → templates/admin/products/products-list.html
    }
}