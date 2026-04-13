package org.example.fleetflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculeDTO {
    Long id;
    @NotBlank(message="ce champ est obligatoire")

    String matricule;
    @NotBlank(message="ce champ est obligatoire")

    String type;
    Double capacite;
    @NotBlank(message="ce champ est obligatoire")

    String statut;
}
