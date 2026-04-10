package org.example.fleetflow.controller;

import jakarta.validation.Valid;
import org.example.fleetflow.dto.ChauffeurDTO;
import org.example.fleetflow.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chauffeurs")
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;

    @GetMapping
    public List<ChauffeurDTO> listerChauffeurs() {
        return chauffeurService.getAllChauffeurs();
    }

    @PostMapping
    public ChauffeurDTO ajouterChauffeur(@RequestBody @Valid ChauffeurDTO chauffeurDTO) {
        return chauffeurService.addChauffeur(chauffeurDTO);
    }

    @PutMapping("/{id}")
    public ChauffeurDTO modifierChauffeur(@PathVariable Long id, @RequestBody @Valid ChauffeurDTO chauffeurDTO) {
        return chauffeurService.updateChauffeur(id, chauffeurDTO);
    }

    @DeleteMapping("/{id}")
    public String supprimerChauffeur(@PathVariable Long id) {
        chauffeurService.deleteChauffeur(id);
        return "Chauffeur supprimé avec succès !";
    }

    @GetMapping("/disponibles")
    public List<ChauffeurDTO> listerChauffeursDisponibles() {
        return chauffeurService.getAvailableChauffeurs();
    }

    @GetMapping("/permis/{type}")
    public List<ChauffeurDTO> listerParPermis(@PathVariable String type) {
        return chauffeurService.getByPermisType(type);
    }
}
