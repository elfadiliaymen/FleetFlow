package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.dto.ClientDTO;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.mapper.ClientMapper;
import org.example.fleetflow.repository.ClientRepository;
import org.example.fleetflow.repository.LivraisonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ClientService {
   final private ClientRepository clientRepository;
   final private ClientMapper clientMapper;
   final private LivraisonRepository livraisonRepository;


    public ClientDTO ajouterClient(ClientDTO clientDTO){
        Client client=clientMapper.toEntity(clientDTO);
        Client savedClient=clientRepository.save(client);
        return clientMapper.toDTO(savedClient);

    }

    public ClientDTO modifierClient(long id,ClientDTO clientDTO){
        Client nouvClient=clientRepository.findById(id).get();
        nouvClient.setEmail(clientDTO.getEmail());
        nouvClient.setNom(clientDTO.getNom());
        nouvClient.setTelephone(clientDTO.getTelephone());
        nouvClient.setVille(clientDTO.getVille());
        Client updateClient =clientRepository.save(nouvClient);
        return clientMapper.toDTO(updateClient);
    }
    public List<ClientDTO>listerClients(){
        List<Client> clients=clientRepository.findAll();
        List<ClientDTO> dtos = new ArrayList<>();

        for(Client c : clients){
          long count = livraisonRepository.countByClientId(c.getId());
          ClientDTO clientDTO =  clientMapper.toDTO(c);
         clientDTO.setTotalLivraisons(count);
        dtos.add(clientDTO);
        }
        return dtos;
    }
    public void  SupprimerClient(Long id){

        clientRepository.deleteById(id);
    }

}

