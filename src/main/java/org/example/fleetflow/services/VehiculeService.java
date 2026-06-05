package org.example.fleetflow.services;

import org.example.fleetflow.dto.VehiculeDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VehiculeService {
    VehiculeDTO ajouterVehicule(VehiculeDTO vehiculeDTO);
    List<VehiculeDTO> getAllVehicules();
    VehiculeDTO modifierVehicule(long id,VehiculeDTO  vehiculeDTO);
    void SupprimerVehicule(long id);
    List<VehiculeDTO>getVehiculeDisponibles();
    List<VehiculeDTO>getVehiculeByStatut(String statut);
    List<VehiculeDTO>getVehiculesCapaciteSuperieur(double capacite);
    Page<VehiculeDTO> vehiculesTriesEtPagines(int page, int size, String sortBy, String destination);



}

