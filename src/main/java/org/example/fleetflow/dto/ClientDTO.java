package org.example.fleetflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

    String nom;
    @Email(message="email n'est pas valide")
    @NotBlank(message="email est obligatoire")
    String email;


    String ville;
    @NotBlank(message="ce champ est obligatoire")

    String telephone;
}
