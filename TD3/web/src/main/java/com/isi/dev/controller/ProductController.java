package com.isi.dev.controller;



import com.isi.dev.model.Product;
import com.isi.dev.service.IWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {

    @Autowired
    public IWebService webService;

    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", webService.findAll());
        return "home";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String ref, @RequestParam String name, Model model) {
        webService.save(new Product(ref, name));
        model.addAttribute("products", webService.findAll());
        return "home";
    }

}
