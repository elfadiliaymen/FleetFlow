package org.example.fleetflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
//    @NotNull(message="ce champ doit pas etre null")
    Long id;
    @NotBlank(message="ce champ est obligatoire")

    String nom;
    @Email(message="email n'est pas valide")
    String email;
    @NotBlank(message="ce champ est obligatoire")

    String ville;
    @NotBlank(message="ce champ est obligatoire")

    String telephone;
}
