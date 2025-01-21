package com.isi.dev.controller;


import com.isi.dev.model.AppUser;
import com.isi.dev.service.IWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppUserController {

    @Autowired
    public IWebService webService;

    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", webService.findAll());
        return "home";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam Long id, @RequestParam String name, Model model) {
        System.out.println("id : " + id);
        System.out.println("name : " + name);
        webService.save(new AppUser(id, name));
        model.addAttribute("users", webService.findAll());
        return "home";
    }

}
