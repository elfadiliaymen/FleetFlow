package org.example.fleetflow.repository;

import org.example.fleetflow.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
    List<Vehicule>findByStatut(String statut);
    List<Vehicule> findByCapaciteGreaterThan(double capacite);
    //7-Afficher les véhicules disponibles avec une capacité supérieure à une valeur donnée.
    List<Vehicule>findByDisponibleAndCapaciteGreaterThan(Double capacite,Boolean disponible );
    //8-Afficher les véhicules d’un type donné triés par capacité.
    List<Vehicule>findByTypeAndOrderByCapacite(String type);



}
