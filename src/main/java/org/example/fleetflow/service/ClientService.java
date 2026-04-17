package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.dto.ClientDTO;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.mapper.ClientMapper;
import org.example.fleetflow.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;


    public ClientDTO ajouterClient(ClientDTO clientDTO){
        Client client=clientMapper.toEntity(clientDTO);
        if(clientRepository.existsByEmail(clientDTO.getEmail())){
            throw new RuntimeException("email deja existe");

        }
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
        return clientMapper.toDTOList(clients);
    }
    public void  SupprimerClient(Long id){

        clientRepository.deleteById(id);
    }

}

