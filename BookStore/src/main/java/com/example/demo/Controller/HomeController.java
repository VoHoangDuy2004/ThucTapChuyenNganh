package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Micas");
        model.addAttribute("username", "Duy");
        return "index";
    }
    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }
}
