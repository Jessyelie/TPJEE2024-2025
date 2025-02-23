package com.isi.dev.web.Controller;



import com.isi.dev.services.Entity.Kind;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kinds")
public class KindController {


    private final EcoleService ecoleService;

    @GetMapping
    public List<Kind> obtenirTousLesTypes() {
        return ecoleService.trouverTousLesTypes();
    }

    @GetMapping("/{id}")
    public Optional<Kind> obtenirTypeParId(@PathVariable Long id) {
        return ecoleService.trouverTypeParId(id);
    }

    @PostMapping
    public Kind ajouterType(@RequestBody Kind kind) {
        return ecoleService.ajouterType(kind);
    }

    @PutMapping("/{id}")
    public Kind modifierType(@PathVariable Long id, @RequestBody Kind kind) {
        kind.setId(id);
        return ecoleService.modifierType(kind);
    }

    @DeleteMapping("/{id}")
    public void supprimerType(@PathVariable Long id) {
        ecoleService.supprimerType(id);
    }
}

