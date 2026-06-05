package org.example.fleetflow.controller;

import jakarta.validation.Valid;
import org.example.fleetflow.dto.VehiculeDTO;
import org.example.fleetflow.mapper.VehiculeMapper;
import org.example.fleetflow.services.imp.VehiculeServiceImp;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicules")


public class VehiculeController {
    private final VehiculeServiceImp vehiculeServiceImp;
    private final VehiculeMapper vehiculeMapper;


    public VehiculeController(VehiculeServiceImp vehiculeServiceImp, VehiculeMapper vehiculeMapper) {
        this.vehiculeServiceImp = vehiculeServiceImp;
        this.vehiculeMapper = vehiculeMapper;
    }

    @GetMapping
    public List<VehiculeDTO> listerVehicules() {
        return vehiculeServiceImp.getAllVehicules();
    }

    @GetMapping("/disponible")
    public List<VehiculeDTO> listerVehiculesDisponibles() {
        return vehiculeServiceImp.getVehiculeDisponibles();
    }

    @PostMapping
    public ResponseEntity<VehiculeDTO> ajouterVehicule(
            @Valid @RequestBody VehiculeDTO vehiculeDTO
    ) {
        return ResponseEntity.ok(vehiculeServiceImp.ajouterVehicule(vehiculeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculeDTO> modifierVehicule(@PathVariable long id, @Valid @RequestBody VehiculeDTO vehiculeDTO) {
        return ResponseEntity.ok(vehiculeServiceImp.modifierVehicule(id, vehiculeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable long id) {
        vehiculeServiceImp.SupprimerVehicule(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("statut/{statut}")
    public ResponseEntity<List<VehiculeDTO>> getVehiculesByStatut(@PathVariable String statut) {
        return ResponseEntity.ok(vehiculeServiceImp.getVehiculeByStatut(statut));

    }

    @GetMapping("capacite/{capacite}")
    public ResponseEntity<List<VehiculeDTO>> getVehiculesCapaciteSuperieur(@PathVariable double capacite) {
        return ResponseEntity.ok(vehiculeServiceImp.getVehiculesCapaciteSuperieur(capacite));

    }

    @GetMapping("/vehiculesTriesEtPagines")
    public ResponseEntity<Page<VehiculeDTO>> vehiculesTriesEtPagines(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "capacite") String sortBy,
            @RequestParam(defaultValue = "asc") String destination


    ) {
        Page<VehiculeDTO> vehiculeDTOS = vehiculeServiceImp.vehiculesTriesEtPagines(page, size, sortBy, destination);
        return ResponseEntity.ok(vehiculeDTOS);


    }
}
