package org.example.fleetflow.controller;

import lombok.AllArgsConstructor;
import org.example.fleetflow.entity.Vehicule;
import org.example.fleetflow.service.ClientService;
import org.example.fleetflow.service.VehiculeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VehiculeController {
    private final VehiculeService vehiculeService;
    private final ClientService clientService;

    public VehiculeController(VehiculeService vehiculeService, ClientService clientService) {
    this.vehiculeService=vehiculeService;
        this.clientService = clientService;
    }
@RequestMapping("/vehicules")
@GetMapping("/{capacite}")
    public List<Vehicule>listerVehiculesDisponibles(@PathVariable String Statut){
    return vehiculeService.getVehiculeDisponibles();
}
@PostMapping
    public ResponseEntity<Vehicule>ajouterVehicule(
            @RequestParam String matricule,
            @RequestParam String type,
            @RequestParam Double capacite,
            @RequestParam String Statut
){
    Vehicule vehicule = new Vehicule();
    vehicule.setMatricule(matricule);
    vehicule.setType(type);
    vehicule.setCapacite(capacite);
    vehicule.setStatut(Statut);
    return ResponseEntity.ok(vehiculeService.ajouterVehicule(vehicule));
}




}
