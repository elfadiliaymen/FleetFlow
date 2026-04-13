package org.example.fleetflow.repository;

import org.example.fleetflow.model.Client;
import org.example.fleetflow.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

    List<Livraison> findByStatut(String statut);

    List<Livraison> findByChauffeurId(Long chauffeurId);

    List<Livraison> findByClientId(Long clientId);

    @Query("SELECT l FROM Livraison l WHERE l.dateLivraison BETWEEN :startDate AND :endDate")
    List<Livraison> findLivraisonsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT l FROM Livraison l WHERE l.adresseDestination LIKE %:ville%")
    List<Livraison> findLivraisonsByVilleDestination(@Param("ville") String ville);
    //1-Afficher toutes les livraisons depuis une ville donnée.
    List<Livraison>findByVille(String ville);

//2-Afficher les livraisons dont la destination contient un mot clé.
    List<Livraison>findByAdresseDestinationContaining(String adresseDestination);


    //3-Afficher les livraisons du plus récent au plus ancien.
    List<Livraison>findByOrderByDateDesc();
    //4-Afficher les livraisons d’un client pour un statut donné.
    List<Livraison>findByClientIdAndStatut(Long clientId,String statut);

//9-Afficher les livraisons dont le chauffeur est disponible.

    @Query(value="SELECT * FROM Livraison l JOIN Chauffeur c ON l.chauffeur_id=c.id where c.disponible ==true" ,nativeQuery = true)
    List<Livraison>afficherLivraisonDisponible();

}

