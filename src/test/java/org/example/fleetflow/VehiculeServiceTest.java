package org.example.fleetflow;

import org.example.fleetflow.dto.VehiculeDTO;
import org.example.fleetflow.mapper.ClientMapper;
import org.example.fleetflow.mapper.VehiculeMapper;
import org.example.fleetflow.model.Vehicule;
import org.example.fleetflow.repository.VehiculeRepository;
import org.example.fleetflow.service.ClientService;
import org.example.fleetflow.service.VehiculeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehiculeServiceTest {
    @Mock
    VehiculeRepository vehiculeRepository;
    @Mock
    VehiculeMapper vehiculeMapper ;
    @InjectMocks
    VehiculeService vehiculeService ;
@Test
    void listerVehiculesDisponibles(){
        String disponible="disponible";
        Vehicule vehicule = new Vehicule();
        VehiculeDTO vehiculeDTO= new VehiculeDTO();
        List<Vehicule> vehicules= List.of(vehicule);
        List<VehiculeDTO>vehiculeDTOS= List.of(vehiculeDTO);

        when(vehiculeRepository.findByStatut(disponible)).thenReturn(vehicules);
        when(vehiculeMapper.toDTOList(vehicules)).thenReturn(vehiculeDTOS);

        List<VehiculeDTO> resultat= vehiculeService.getVehiculeDisponibles();

        verify(vehiculeMapper,times(1)).toDTOList(vehicules);
        verify(vehiculeRepository,times(1)).findByStatut(disponible);

        assertNotNull(resultat);
        assertEquals(1,resultat.size());







}
    @Test
    void verifier_capacite(){
    Double capacite=100.0;
    Vehicule vehicule = new Vehicule();
    VehiculeDTO vehiculeDTO = new VehiculeDTO();
    List<Vehicule> vehicules= List.of(vehicule);
    List<VehiculeDTO>vehiculeDTOS= List.of(vehiculeDTO);

    when(vehiculeRepository.findByCapaciteGreaterThan(capacite)).thenReturn(vehicules);
    when(vehiculeMapper.toDTOList(vehicules)).thenReturn(vehiculeDTOS);

    List<VehiculeDTO> resultat= vehiculeService.getVehiculesCapaciteSuperieur(capacite);


    verify(vehiculeRepository,times(1)).findByCapaciteGreaterThan(capacite);
    verify(vehiculeMapper,times(1)).toDTOList(vehicules);


    assertNotNull(resultat);
    assertEquals(1,resultat.size());








    }

}
