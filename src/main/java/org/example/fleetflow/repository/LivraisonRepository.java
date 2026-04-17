package org.example.fleetflow.repository;

import org.example.fleetflow.model.Chauffeur;
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

    @Query(value="SELECT * FROM Livraison l JOIN Chauffeur c ON l.chauffeur_id=c.id where c.disponible =true" ,nativeQuery = true)
    List<Livraison>afficherLivraisonDisponible();
    //10-Afficher les livraisons assignées à des véhicules disponibles.

    @Query(value="SELECT * FROM LIVRAISON l JOIN Vehicule v ON v.id=l.vehicule_id where v.statut=disponible",nativeQuery = true)
    List<Livraison>livraisonsVehiculesDisponibles();
//11-Afficher les livraisons selon la ville du client.
    @Query(value="SELECT * FROM LIVRAISON l JOIN CLIENT c  ON c.id=l.client_id where c.ville = :ville",nativeQuery = true)
    List<Livraison>livraisonsVilleClient(@Param("ville")String ville);

    //12-Afficher les livraisons planifiées après la date actuelle.
    @Query(value="SELECT * FROM LIVRAISON l WHERE  l.date_livraison > CURRENT_DATE()",nativeQuery = true)
    List<Livraison>livraisonsApresDateActuelle();
    //13-Nombre de livraisons par statut

    @Query(value="SELECT  statut,COUNT(*) FROM LIVRAISON GROUP BY statut",nativeQuery = true)
    List<Object[]>  nombreLivraisonsStatut();
    //14-Afficher le nombre de livraisons par ville destination.

    @Query(value="SELECT adresse_destination,COUNT(*) FROM LIVRAISON GROUP BY adresse_destination",nativeQuery = true)
    List<Object[]> nombreLivraisonVille();

    //15-Afficher la dernière livraison pour chaque client.

    @Query(value="SELECT * FROM Livraison l  WHERE (l.client_id,l.date_livraison) IN (SELECT  client_id ,MAX (date_livraison) FROM LIVRAISON GROUP BY client_id)",nativeQuery = true)
    List<Livraison>derniereLivraisonsClient();

    //16-Afficher les chauffeurs ayant effectué le plus de livraisons.
    @Query(value =" SELECT c FROM Chauffeur c JOIN  Livraison l  ON l.chauffeur_id=c.id WHERE c.id IN(SELECT  chauffeur_id from Chauffeur  c GROUP BY chauffeur_id ),nativeQuery = true  ")
    List<Chauffeur>chauffeurPlusLivraisons();



}

