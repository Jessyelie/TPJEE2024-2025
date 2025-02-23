package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Classes;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/classes")
public class ClassesController {


    private final EcoleService ecoleService;

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

