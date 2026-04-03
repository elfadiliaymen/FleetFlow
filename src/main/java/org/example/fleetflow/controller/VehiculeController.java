package org.example.fleetflow.controller;

import org.example.fleetflow.dto.VehiculeDTO;
import org.example.fleetflow.mapper.VehiculeMapper;
import org.example.fleetflow.service.ClientService;
import org.example.fleetflow.service.VehiculeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicules")


public class VehiculeController {
    private final VehiculeService vehiculeService;
    private final VehiculeMapper vehiculeMapper;


    public VehiculeController(VehiculeService vehiculeService, VehiculeMapper vehiculeMapper) {
        this.vehiculeService = vehiculeService;
        this.vehiculeMapper = vehiculeMapper;
    }

    @GetMapping
    public List<VehiculeDTO> listerVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @GetMapping("/disponible")
    public List<VehiculeDTO> listerVehiculesDisponibles() {
        return vehiculeService.getVehiculeDisponibles();
    }

    @PostMapping
    public ResponseEntity<VehiculeDTO> ajouterVehicule(
            @RequestBody VehiculeDTO vehiculeDTO
    ) {
        return ResponseEntity.ok(vehiculeService.ajouterVehicule(vehiculeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculeDTO> modifierVehicule(@PathVariable long id, @RequestBody VehiculeDTO vehiculeDTO) {
        return ResponseEntity.ok(vehiculeService.modifierVehicule(id, vehiculeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable long id) {
        vehiculeService.SupprimerVehicule(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("statut/{statut}")
    public ResponseEntity<List<VehiculeDTO>> getVehiculesByStatut(@PathVariable String statut) {
        return ResponseEntity.ok(vehiculeService.getVehiculeByStatut(statut));

    }

    @GetMapping("capacite/{capacite}")
    public ResponseEntity<List<VehiculeDTO>> getVehiculesCapaciteSuperieur(@PathVariable double capacite) {
        return ResponseEntity.ok(vehiculeService.getVehiculesCapaciteSuperieur(capacite));

    }


}
