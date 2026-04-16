package org.example.fleetflow;

import org.example.fleetflow.dto.ClientDTO;
import org.example.fleetflow.mapper.ClientMapper;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.repository.ClientRepository;
import org.example.fleetflow.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @InjectMocks
    ClientService clientService;
    @Mock
    ClientRepository clientRepository;
    @Mock
    ClientMapper clientMapper;
    @Test
    void ajouterClient(){
        ClientDTO clientDTO= new ClientDTO();
        clientDTO.setNom("Imane");
        Client client = new Client();
        client.setNom("Imane");
        Client savedClient= new Client();
        savedClient.setNom("Imane");
        ClientDTO returnedDTO = new ClientDTO();
        returnedDTO.setNom("Imane");


        when(clientMapper.toEntity(clientDTO)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(savedClient);
        when(clientMapper.toDTO(savedClient)).thenReturn(returnedDTO);
        ClientDTO resClientDTO=clientService.ajouterClient(clientDTO);


        assertNotNull(resClientDTO);
        assertEquals("Imane",resClientDTO.getNom());
        verify(clientMapper,times(1)).toEntity(clientDTO);
        verify(clientRepository,times(1)).save(client);
        verify(clientMapper,times(1)).toDTO(savedClient);


    }
    @Test
    void verifier_email(){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("imane@gmail.com");



        when(clientRepository.existsByEmail("imane@gmail.com")).thenReturn(true);

        assertThrows(RuntimeException.class,()->
                clientService.ajouterClient(clientDTO));

        verify(clientRepository,never()).save(any());




    }


}
