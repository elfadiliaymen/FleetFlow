package org.example.fleetflow.repository;

import org.example.fleetflow.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
    List<Vehicule>findByStatut(String statut);
    List<Vehicule>findByCapaciteGreaterThan(Double capacite);

}
