package org.example.fleetflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private String statut;

    @ManyToOne
    private Chauffeur chauffeur;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Vehicule vehicule;
}
