package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.entity.Client;
import org.example.fleetflow.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public Client ajouterClient(Client client){
        return clientRepository.save(client);
    }
    public Client modifierClient(long id,String nvNom,String nvEmail,String ville,String nvTelephone){
        Client nouvClient=clientRepository.findById(id).get();
        nouvClient.setEmail(nvEmail);
        nouvClient.setNom(nvNom);
        nouvClient.setTelephone(nvTelephone);
        nouvClient.setVille(ville);
        clientRepository.save(nouvClient);
        return nouvClient;
    }
    public List<Client>listerClients(){
        return clientRepository.findAll();
    }
    public void  SupprimerClient(Long id){
            clientRepository.deleteById(id);
    }

}

