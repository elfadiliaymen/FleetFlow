package org.example.fleetflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Vehicule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String type;
    private double capacite;
    private String statut;

}
