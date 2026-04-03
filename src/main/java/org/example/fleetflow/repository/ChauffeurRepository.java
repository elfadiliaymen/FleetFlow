package org.example.fleetflow.repository;

import org.example.fleetflow.model.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
    List<Chauffeur> findByDisponibleTrue();
    List<Chauffeur> findByPermisType(String permisType);
}
