package org.example.fleetflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChauffeurDTO {
    @NotNull(message="ce champ ne doit pas etre null")
    private Long id;
    @NotBlank(message="le nom est obligatoire")
    private String nom;
    @NotBlank(message="le telephone est obligatoire")

    private String telephone;
    @NotBlank(message="ce champ est obligatoire")

    private String permisType;
    private boolean disponible;
}