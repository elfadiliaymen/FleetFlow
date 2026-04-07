package org.example.fleetflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    Long id;
    String nom;
    String email;
    String ville;
    String telephone;
}
