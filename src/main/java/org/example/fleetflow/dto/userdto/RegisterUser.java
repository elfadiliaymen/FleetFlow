package org.example.fleetflow.dto.userdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterUser {
    @Email(message="format email invalide")
    private String email;
    @NotBlank(message = "ce champ est obligatoire")

    private String username;
    @NotBlank(message = "ce champ est obligatoire")

    private String password;
    @NotBlank(message = "ce champ est obligatoire")

    private String role;
}
