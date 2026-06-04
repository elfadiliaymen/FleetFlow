package org.example.fleetflow.dto.userdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginUser {
    @Email(message="format d'email invalide")
    private String email;
    @NotBlank(message = "ce champs est obligatoire")
    private String password;
}
