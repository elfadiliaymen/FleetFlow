package org.example.fleetflow.controller;

import jakarta.validation.Valid;
import org.example.fleetflow.dto.ClientDTO;
import org.example.fleetflow.service.ClientService;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<ClientDTO> ajouterClient(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.ajouterClient(clientDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO>modifierClient(@PathVariable long id,@Valid @RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok(clientService.modifierClient(id,clientDTO));



    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>supprimerClient(@PathVariable long id){
        clientService.SupprimerClient(id);
        return ResponseEntity.ok().build();



    }
    @GetMapping("/clientsPaginesEtTries")
    public ResponseEntity<Page<ClientDTO>>clientsPaginesEtTries(
            @RequestParam (defaultValue = "0")int page,
            @RequestParam(defaultValue ="20")int size,
            @RequestParam (defaultValue ="nom" )String sortBy,
            @RequestParam (defaultValue ="asc" )String destination

    ){
        Page<ClientDTO>clients=clientService.clientsPaginesEtTries(page,size,sortBy,destination);

        return ResponseEntity.ok(clients);
    }


}
