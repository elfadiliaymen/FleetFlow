package org.example.fleetflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivraisonDTO {
    private Long id;
    private LocalDateTime dateLivraison;
    @NotBlank(message="ce champ est obligatoire")

    private String adresseDepart;
    @NotBlank(message="ce champ est obligatoire")

    private String adresseDestination;
    @NotBlank(message="ce champ est obligatoire")

    private String statut;
    private Long chauffeurId;
    private Long clientId;
    private Long vehiculeId;
}
