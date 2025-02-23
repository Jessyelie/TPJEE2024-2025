package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Student;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final EcoleService ecoleService;

    @GetMapping
    public List<Student> obtenirTousLesEtudiants() {
        return ecoleService.trouverTousLesEtudiants();
    }

    @GetMapping("/{id}")
    public Optional<Student> obtenirEtudiantParId(@PathVariable Long id) {
        return ecoleService.trouverEtudiantParId(id);
    }

    @PostMapping
    public Student ajouterEtudiant(@RequestBody Student student) {
        return ecoleService.ajouterEtudiant(student);
    }

    @PutMapping("/{id}")
    public Student modifierEtudiant(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return ecoleService.modifierEtudiant(student);
    }

    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable Long id) {
        ecoleService.supprimerEtudiant(id);
    }
}
