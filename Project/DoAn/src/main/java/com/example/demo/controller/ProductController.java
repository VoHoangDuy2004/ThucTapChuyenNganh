package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/product-list")
    public String list(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "admin/product/product";
    }

    @GetMapping("/product-add-form")
    public String viewProduct(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        List<Category>categories=categoryService.findAll();
        model.addAttribute("categories",categories);
        return "admin/product/product-add-form";
    }

    @PostMapping("/product-add-form")
    public String save(@ModelAttribute("product") Product product) {
        //System.out.println(product.toString());
        productService.save(product);

        return "redirect:/admin/product/product-list";
    }

    @GetMapping("/product-edit-form")
    public String viewEdit(@RequestParam("id") int id, Model model){
        Product product=productService.findById(id);
        System.out.println(product.toString());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product",product);
        return "admin/product/product-edit-form";
    }
    @GetMapping("/product-delete-form")
    public String viewDelete(@RequestParam("id")int id, Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "admin/product/product-delete-form";
    }
    @PostMapping("/product-delete-form")
    public String delete(@RequestParam("id") int id){
        productService.deleteById(id);
        return "redirect:/admin/product/product-list";
    }


}