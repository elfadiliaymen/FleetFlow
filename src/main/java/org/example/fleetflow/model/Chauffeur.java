package org.example.fleetflow.model;


import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Chauffeur extends User {


    private String nom;
    private String telephone;
    private String permisType;
    private boolean disponible;

}
