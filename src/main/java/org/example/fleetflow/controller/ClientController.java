package org.example.fleetflow.controller;

import org.example.fleetflow.dto.ClientDTO;
import org.example.fleetflow.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clients")


public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping
    public List<ClientDTO> listeClients(){
        return clientService.listerClients();

    }
   @PostMapping
    public ResponseEntity<ClientDTO> ajouterClient(
            @RequestParam String nom,
            @RequestParam String email,
            @RequestParam String telephone,
            @RequestParam  String ville
    ) {
        ClientDTO clientDTO = new ClientDTO();
       clientDTO.setNom(nom);
       clientDTO.setEmail(email);
       clientDTO.setTelephone(telephone);
       clientDTO.setVille(ville);
        return ResponseEntity.ok(clientService.ajouterClient(clientDTO));

    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO>modifierClient(@PathVariable long id,@RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok(clientService.modifierClient(id,clientDTO));



    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>supprimerClient(@PathVariable long id){
        clientService.SupprimerClient(id);
        return ResponseEntity.ok().build();



    }
}
