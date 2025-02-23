package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Sessions;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sessions")
public class SessionsController {

    private final EcoleService ecoleService;

    @GetMapping
    public List<Sessions> obtenirToutesLesSessions() {
        return ecoleService.trouverToutesLesSessions();
    }

    @GetMapping("/{id}")
    public Optional<Sessions> obtenirSessionParId(@PathVariable Long id) {
        return ecoleService.trouverSessionParId(id);
    }

    @PostMapping
    public Sessions ajouterSession(@RequestBody Sessions session) {
        return ecoleService.ajouterSession(session);
    }

    @PutMapping("/{id}")
    public Sessions modifierSession(@PathVariable Long id, @RequestBody Sessions session) {
        session.setId(id);
        return ecoleService.modifierSession(session);
    }

    @DeleteMapping("/{id}")
    public void supprimerSession(@PathVariable Long id) {
        ecoleService.supprimerSession(id);
    }
}

