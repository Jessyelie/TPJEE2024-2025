package com.isi.dev.web.Controller;

import com.isi.dev.services.Entity.AdministrativeAgent;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/administrative-agents")
public class AdministrativeAgentController {

    private final EcoleService ecoleService;

    @GetMapping
    public List<AdministrativeAgent> obtenirTousLesAgentsAdministratifs() {
        return ecoleService.trouverTousLesAgentsAdministratifs();
    }

    @GetMapping("/{id}")
    public Optional<AdministrativeAgent> obtenirAgentAdministratifParId(@PathVariable Long id) {
        return ecoleService.trouverAgentAdministratifParId(id);
    }

    @PostMapping
    public AdministrativeAgent ajouterAgentAdministratif(@RequestBody AdministrativeAgent agent) {
        return ecoleService.ajouterAgentAdministratif(agent);
    }

    @PutMapping("/{id}")
    public AdministrativeAgent modifierAgentAdministratif(@PathVariable Long id, @RequestBody AdministrativeAgent agent) {
        agent.setId(id);
        return ecoleService.modifierAgentAdministratif(agent);
    }

    @DeleteMapping("/{id}")
    public void supprimerAgentAdministratif(@PathVariable Long id) {
        ecoleService.supprimerAgentAdministratif(id);
    }
}
