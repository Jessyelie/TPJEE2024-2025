package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Subjects;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subjects")
public class SubjectsController {


    private final EcoleService ecoleService;

    @GetMapping
    public List<Subjects> obtenirToutesLesMatieres() {
        return ecoleService.trouverToutesLesMatières();
    }

    @GetMapping("/{id}")
    public Optional<Subjects> obtenirMatiereParId(@PathVariable Long id) {
        return ecoleService.trouverMatiereParId(id);
    }

    @PostMapping
    public Subjects ajouterMatiere(@RequestBody Subjects subject) {
        return ecoleService.ajouterMatiere(subject);
    }

    @PutMapping("/{id}")
    public Subjects modifierMatiere(@PathVariable Long id, @RequestBody Subjects subject) {
        subject.setId(id);
        return ecoleService.modifierMatiere(subject);
    }

    @DeleteMapping("/{id}")
    public void supprimerMatiere(@PathVariable Long id) {
        ecoleService.supprimerMatiere(id);
    }
}
