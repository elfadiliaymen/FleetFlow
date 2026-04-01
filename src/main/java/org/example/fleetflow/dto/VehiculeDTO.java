package org.example.fleetflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculeDTO {
    Long id;
    String matricule;
    String type;
    Double capacite;
    String statut;
}
