package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String Admin(){
        return "admin";
    }
    @GetMapping("/admin/categories")
    public String viewCategory() {
        return "admin/category/categories";
    }

    @GetMapping("/admin/products")
    public String viewProducts() {
        return "admin/product/products";
    }
    @GetMapping("/buttons")
    public String Buttons(){
        return "admin/buttons";
    }
    @GetMapping("/cards")
    public String Cards(){
        return "admin/cards";
    }
    @GetMapping("/utilities-color")
    public String UtilitiesColor(){
        return "admin/utilities-color";
    }
    @GetMapping("/utilities-border")
    public String UtilitiesBorder(){
        return "admin/utilities-border";
    }
    @GetMapping("/utilities-animation")
    public String UtilitiesAnimation(){
        return "admin/utilities-animation";
    }
    @GetMapping("/utilities-other")
    public String UtilitiesOther(){
        return "admin/utilities-other";
    }
    @GetMapping("/notfound")
    public String NotFound(){
        return "admin/notfound";
    }
    @GetMapping("/blank")
    public String Blank(){
        return "admin/blank";
    }
    @GetMapping("/charts")
    public String Charts(){
        return "admin/charts";
    }
    @GetMapping("/tables")
    public String Tables(){
        return "admin/tables";
    }
    @GetMapping("/catalogry")
    public String Catalogry(){
        return "admin/catalogry";
    }
}
