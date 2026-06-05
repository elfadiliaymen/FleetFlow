package org.example.fleetflow.controller;

import lombok.RequiredArgsConstructor;
import org.example.fleetflow.dto.ChauffeurDTO;
import org.example.fleetflow.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chauffeurs")
public class ChauffeurController {


    private final ChauffeurService chauffeurService;

    @GetMapping
    public List<ChauffeurDTO> listerChauffeurs() {
        return chauffeurService.getAllChauffeurs();
    }

    @PostMapping
    public ChauffeurDTO ajouterChauffeur(@RequestBody ChauffeurDTO chauffeurDTO) {
        return chauffeurService.addChauffeur(chauffeurDTO);
    }

    @PutMapping("/{id}")
    public ChauffeurDTO modifierChauffeur(@PathVariable Long id, @RequestBody ChauffeurDTO chauffeurDTO) {
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

    @GetMapping("/chauffeursTriesEtPagines")
    public ResponseEntity<Page<ChauffeurDTO>>chauffeursTriesEtPagines(
            @RequestParam(defaultValue ="0")int page,
            @RequestParam(defaultValue ="20")int size,
            @RequestParam(defaultValue ="nom")String sortBy,
            @RequestParam(defaultValue ="asc")String destination


    )
    {
        Page<ChauffeurDTO> chauffeurDTOS=chauffeurService.chauffeursTriesEtPagines(page,size,sortBy,destination);
        return ResponseEntity.ok(chauffeurDTOS);



    }
}
