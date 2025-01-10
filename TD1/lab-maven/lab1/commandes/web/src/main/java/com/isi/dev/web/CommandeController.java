package com.isi.dev.web;

import com.isi.dev.services.ICommande;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CommandeController {
    public ICommande commande;

    @GetMapping(name = "commande", value="/commande")
    public String commandeController() {
        return commande.getCommande();
    }
}
