package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @GetMapping("/login")
    public String Login(){
        return "login";
    }
    @GetMapping("/forgot-password")
    public String ForgotPassword() {
        return "admin/forgot-password";
    }
    @GetMapping("/register")
    public String Register() {
        return "admin/register";
    }

}
