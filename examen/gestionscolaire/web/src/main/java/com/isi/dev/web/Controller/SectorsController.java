package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.Sectors;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sectors")
public class SectorsController {

    private final EcoleService ecoleService;

    @GetMapping
    public List<Sectors> obtenirTousLesSecteurs() {
        return ecoleService.trouverTousLesSecteurs();
    }

    @GetMapping("/{id}")
    public Optional<Sectors> obtenirSecteurParId(@PathVariable Long id) {
        return ecoleService.trouverSecteurParId(id);
    }

    @PostMapping
    public Sectors ajouterSecteur(@RequestBody Sectors sector) {
        return ecoleService.ajouterSecteur(sector);
    }

    @PutMapping("/{id}")
    public Sectors modifierSecteur(@PathVariable Long id, @RequestBody Sectors sector) {
        sector.setId(id);
        return ecoleService.modifierSecteur(sector);
    }

    @DeleteMapping("/{id}")
    public void supprimerSecteur(@PathVariable Long id) {
        ecoleService.supprimerSecteur(id);
    }
}
