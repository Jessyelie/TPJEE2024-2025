package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Courses;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final EcoleService ecoleService;

    @GetMapping
    public List<Courses> obtenirTousLesCours() {
        return ecoleService.trouverTousLesCours();
    }

    @GetMapping("/{id}")
    public Optional<Courses> obtenirCoursParId(@PathVariable Long id) {
        return ecoleService.trouverCoursParId(id);
    }

    @PostMapping
    public Courses ajouterCours(@RequestBody Courses course) {
        return ecoleService.ajouterCours(course);
    }

    @PutMapping("/{id}")
    public Courses modifierCours(@PathVariable Long id, @RequestBody Courses course) {
        course.setId(id);
        return ecoleService.modifierCours(course);
    }

    @DeleteMapping("/{id}")
    public void supprimerCours(@PathVariable Long id) {
        ecoleService.supprimerCours(id);
    }
}

