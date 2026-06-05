package org.example.fleetflow.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.fleetflow.dto.LivraisonDTO;
import org.example.fleetflow.services.LivraisonService;
import org.example.fleetflow.services.imp.LivraisonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/livraisons")
public class LivraisonController {


    private final LivraisonService livraisonService;

    @PostMapping
    public LivraisonDTO creerLivraison(@Valid @RequestBody LivraisonDTO livraisonDTO) {
        return livraisonService.createLivraison(livraisonDTO);
    }

    @PutMapping("/{id}/statut")
    public LivraisonDTO modifierStatut(@PathVariable Long id,@Valid @RequestParam String statut) {
        return livraisonService.updateStatut(id, statut);
    }

    @PutMapping("/{id}/assigner-chauffeur/{chauffeurId}")
    public LivraisonDTO assignerChauffeur(@PathVariable Long id, @PathVariable Long chauffeurId) {
        return livraisonService.assignChauffeur(id, chauffeurId);
    }

    @PutMapping("/{id}/assigner-vehicule/{vehiculeId}")
    public LivraisonDTO assignerVehicule(@PathVariable Long id, @PathVariable Long vehiculeId) {
        return livraisonService.assignVehicule(id, vehiculeId);
    }

    @GetMapping
    public List<LivraisonDTO> listerLivraisons() {
        return livraisonService.getAllLivraisons();
    }

    @GetMapping("/statut/{statut}")
    public List<LivraisonDTO> listerParStatut(@PathVariable String statut) {
        return livraisonService.getByStatut(statut);
    }

    @GetMapping("/client/{clientId}")
    public List<LivraisonDTO> listerParClient(@PathVariable Long clientId) {
        return livraisonService.getByClient(clientId);
    }

    @GetMapping("/recherche-par-dates")
    public List<LivraisonDTO> listerEntreDeuxDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime debut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return livraisonService.getBetweenDates(debut, fin);
    }

    @GetMapping("/recherche-par-ville")
    public List<LivraisonDTO> listerParVille(@RequestParam String ville) {
        return livraisonService.getByVille(ville);
    }

    @GetMapping("/chauffeur/{chauffeurId}")
    public List<LivraisonDTO> listerParChauffeur(@PathVariable Long chauffeurId) {
        return livraisonService.getByChauffeur(chauffeurId);
    }

    @GetMapping("/livraisonsTriesEtPagines")
    public ResponseEntity<Page<LivraisonDTO>> livraisonTriesEtPagines(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "dateLivraison") String sortBy,
            @RequestParam(defaultValue = "asc") String destination


    ) {
        Page<LivraisonDTO> livraisonDTOS = livraisonService.livraisonTriesEtPagines(page, size, sortBy, destination);
        return ResponseEntity.ok(livraisonDTOS);

    }
}
