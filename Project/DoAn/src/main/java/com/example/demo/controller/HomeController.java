package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.View;
import java.util.List;

@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final ProductService productService;

    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Category> categories = categoryService.findAllByStatus("active");
        model.addAttribute("categories", categories);
        List<Product> products = productService.findAllByStatus("active");
        model.addAttribute("products", products);
        return "index";
    }
    @GetMapping("/shop")
    public String Shop(Model model){
        List<Product> products = productService.findAllByStatus("active");
        model.addAttribute("products", products);
        return "home/shop";
    }
    @GetMapping("/about")
    public String About(){
        return "home/about";
    }
    @GetMapping("/single-product")
    public String SingleProduct(Model model){
        List<Product> products = productService.findAllByStatus("active");
        model.addAttribute("products", products);
        return "home/single-product";
    }
    @GetMapping("/author")
    public String Author(){
        return "home/author";
    }
    @GetMapping("/account")
    public String Account(){
        return "home/account";
    }
    @GetMapping("/cart")
    public String Cart(){
        return "home/cart";
    }
    @GetMapping("/checkout")
    public String Checkout(){
        return "home/checkout";
    }
    @GetMapping("/blog")
    public String Blog(){
        return "home/blog";
    }
    @GetMapping("/single-post")
    public String SinglePost(){
        return "home/single-post";
    }
    @GetMapping("/contact")
    public String Contact(){
        return "home/contact";
    }
    @GetMapping("/customer")
    public String Customer(){
        return "home/customer";
    }
}
