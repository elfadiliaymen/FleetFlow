package org.example.fleetflow.controller;

import org.example.fleetflow.entity.Client;
import org.example.fleetflow.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
@RequestMapping("/clients")
    @GetMapping
    public List<Client> listeClients(){
        return clientService.listerClients();

    }
   @PostMapping
    public ResponseEntity<Client> ajouterClient(
            @RequestParam String nom,
            @RequestParam String email,
            @RequestParam String telephone,
            @RequestParam  String ville
    ) {
        Client client = new Client();
        client.setNom(nom);
        client.setEmail(email);
        client.setTelephone(telephone);
        client.setVille(ville);
        return ResponseEntity.ok(clientService.ajouterClient(client));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>supprimerClient(@PathVariable long id){
        clientService.SupprimerClient(id);
        return ResponseEntity.ok().build();



    }
}
