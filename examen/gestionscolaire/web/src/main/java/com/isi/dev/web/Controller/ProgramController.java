package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Program;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/programs")
public class ProgramController {


    private final EcoleService ecoleService;

    @GetMapping
    public List<Program> obtenirTousLesProgrammes() {
        return ecoleService.trouverTousLesProgrammes();
    }

    @GetMapping("/{id}")
    public Optional<Program> obtenirProgrammeParId(@PathVariable Long id) {
        return ecoleService.trouverProgrammeParId(id);
    }

    @PostMapping
    public Program ajouterProgramme(@RequestBody Program program) {
        return ecoleService.ajouterProgramme(program);
    }

    @PutMapping("/{id}")
    public Program modifierProgramme(@PathVariable Long id, @RequestBody Program program) {
        program.setId(id);
        return ecoleService.modifierProgramme(program);
    }

    @DeleteMapping("/{id}")
    public void supprimerProgramme(@PathVariable Long id) {
        ecoleService.supprimerProgramme(id);
    }
}
