package com.isi.dev.web.Controller;

import com.isi.dev.services.Entity.Registrations;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/registrations")
public class RegistrationsController {

    private final EcoleService ecoleService;

    @GetMapping
    public List<Registrations> obtenirToutesLesInscriptions() {
        return ecoleService.trouverToutesLesInscriptions();
    }

    @GetMapping("/{id}")
    public Optional<Registrations> obtenirInscriptionParId(@PathVariable Long id) {
        return ecoleService.trouverInscriptionParId(id);
    }

    @PostMapping
    public Registrations ajouterInscription(@RequestBody Registrations registration) {
        return ecoleService.ajouterInscription(registration);
    }

    @PutMapping("/{id}")
    public Registrations modifierInscription(@PathVariable Long id, @RequestBody Registrations registration) {
        registration.setId(id);
        return ecoleService.modifierInscription(registration);
    }

    @DeleteMapping("/{id}")
    public void supprimerInscription(@PathVariable Long id) {
        ecoleService.supprimerInscription(id);
    }
}

