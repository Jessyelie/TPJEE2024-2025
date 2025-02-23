package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Teacher;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final EcoleService ecoleService;

    @GetMapping
    public List<Teacher> obtenirTousLesEnseignants() {
        return ecoleService.trouverTousLesEnseignants();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> obtenirEnseignantParId(@PathVariable Long id) {
        return ecoleService.trouverEnseignantParId(id);
    }

    @PostMapping
    public Teacher ajouterEnseignant(@RequestBody Teacher teacher) {
        return ecoleService.ajouterEnseignant(teacher);
    }

    @PutMapping("/{id}")
    public Teacher modifierEnseignant(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return ecoleService.modifierEnseignant(teacher);
    }

    @DeleteMapping("/{id}")
    public void supprimerEnseignant(@PathVariable Long id) {
        ecoleService.supprimerEnseignant(id);
    }
}

