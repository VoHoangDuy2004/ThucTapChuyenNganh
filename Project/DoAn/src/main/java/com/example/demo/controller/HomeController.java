package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Index(){
        return "index";
    }
    @GetMapping("/shop")
    public String Shop(){
        return "home/shop";
    }
    @GetMapping("/about")
    public String About(){
        return "home/about";
    }
    @GetMapping("/single-product")
    public String SingleProduct(){
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
