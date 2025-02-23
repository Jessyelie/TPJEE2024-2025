package com.groupeisi.gestionclasse.Controller;

import com.groupeisi.gestionclasse.Entity.Classes;
import com.groupeisi.gestionclasse.Service.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    @Autowired
    private EcoleService ecoleService;

    @GetMapping
    public List<Classes> obtenirToutesLesClasses() {
        return ecoleService.trouverToutesLesClasses();
    }

    @GetMapping("/{id}")
    public Optional<Classes> obtenirClasseParId(@PathVariable Long id) {
        return ecoleService.trouverClasseParId(id);
    }

    @PostMapping
    public Classes ajouterClasse(@RequestBody Classes classe) {
        return ecoleService.ajouterClasse(classe);
    }

    @PutMapping("/{id}")
    public Classes modifierClasse(@PathVariable Long id, @RequestBody Classes classe) {
        classe.setId(id);
        return ecoleService.modifierClasse(classe);
    }

    @DeleteMapping("/{id}")
    public void supprimerClasse(@PathVariable Long id) {
        ecoleService.supprimerClasse(id);
    }
}

