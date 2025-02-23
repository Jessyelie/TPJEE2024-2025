package com.isi.dev.web.Controller;




import com.isi.dev.services.Entity.AcademicYear;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/academic-years")
public class AcademicYearController {


    private final EcoleService ecoleService;

    @GetMapping
    public List<AcademicYear> obtenirToutesLesAnneesAcademiques() {
        return ecoleService.trouverToutesLesAnneesAcademiques();
    }

    @GetMapping("/{id}")
    public Optional<AcademicYear> obtenirAnneeAcademiqueParId(@PathVariable Long id) {
        return ecoleService.trouverAnneeAcademiqueParId(id);
    }

    @PostMapping
    public AcademicYear ajouterAnneeAcademique(@RequestBody AcademicYear academicYear) {
        return ecoleService.ajouterAnneeAcademique(academicYear);
    }

    @PutMapping("/{id}")
    public AcademicYear modifierAnneeAcademique(@PathVariable Long id, @RequestBody AcademicYear academicYear) {
        academicYear.setId(id);
        return ecoleService.modifierAnneeAcademique(academicYear);
    }

    @DeleteMapping("/{id}")
    public void supprimerAnneeAcademique(@PathVariable Long id) {
        ecoleService.supprimerAnneeAcademique(id);
    }
}

