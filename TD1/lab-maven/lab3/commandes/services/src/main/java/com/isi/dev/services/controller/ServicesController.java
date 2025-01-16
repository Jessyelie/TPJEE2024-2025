package com.isi.dev.services.controller;

import com.isi.dev.services.service.CommandeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServicesController {

    private final CommandeService commandeService;

    public ServicesController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/commandes")
    public String afficherCommandes() {
        return commandeService.getCommandes();
    }
}
