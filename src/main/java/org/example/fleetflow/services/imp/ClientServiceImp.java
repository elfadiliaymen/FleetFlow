package org.example.fleetflow.services.imp;

import lombok.AllArgsConstructor;
import org.example.fleetflow.dto.ClientDTO;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.mapper.ClientMapper;
import org.example.fleetflow.repository.ClientRepository;
import org.example.fleetflow.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImp implements ClientService {
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

    public Page<ClientDTO>clientsPaginesEtTries(int page,int size, String sortBy, String direction){
        Sort sort=direction.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Client>clients=clientRepository.findAll(pageable);
        return clients.map(clientMapper::toDTO);
    }

}

