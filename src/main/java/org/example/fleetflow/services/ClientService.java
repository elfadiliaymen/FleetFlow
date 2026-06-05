package org.example.fleetflow.services;

import org.example.fleetflow.dto.ClientDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {
    ClientDTO ajouterClient(ClientDTO clientDTO);
    ClientDTO modifierClient(long id,ClientDTO clientDTO);
    List<ClientDTO> listerClients();
    void  SupprimerClient(Long id);
    Page<ClientDTO> clientsPaginesEtTries(int page, int size, String sortBy, String direction);
}
