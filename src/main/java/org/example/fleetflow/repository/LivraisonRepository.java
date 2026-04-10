package org.example.fleetflow.repository;

import org.example.fleetflow.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

//    @Query ("SELECT COUNT(l) from Livraison  l where l.client.id= :idClient")
//    Long CountLivraisonByClient(@Param("idClient") int idClient);

    List<Livraison> findByStatut(String statut);

    List<Livraison> findByChauffeurId(Long chauffeurId);

    List<Livraison> findByClientId(Long clientId);

    @Query("SELECT l FROM Livraison l WHERE l.dateLivraison BETWEEN :startDate AND :endDate")
    List<Livraison> findLivraisonsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT l FROM Livraison l WHERE l.adresseDestination LIKE %:ville%")
    List<Livraison> findLivraisonsByVilleDestination(@Param("ville") String ville);
}
