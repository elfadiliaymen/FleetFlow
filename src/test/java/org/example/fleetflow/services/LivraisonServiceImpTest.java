package org.example.fleetflow.services;

import org.example.fleetflow.dto.LivraisonDTO;
import org.example.fleetflow.mapper.LivraisonMapper;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Livraison;
import org.example.fleetflow.model.Vehicule;
import org.example.fleetflow.repository.ChauffeurRepository;
import org.example.fleetflow.repository.ClientRepository;
import org.example.fleetflow.repository.LivraisonRepository;
import org.example.fleetflow.repository.VehiculeRepository;
import org.example.fleetflow.services.imp.LivraisonServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LivraisonServiceImpTest {

    @Mock
    private LivraisonRepository livraisonRepository;
    @Mock
    private ChauffeurRepository chauffeurRepository;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private VehiculeRepository vehiculeRepository;
    @Mock
    private LivraisonMapper livraisonMapper;

    @InjectMocks
    private LivraisonServiceImp livraisonServiceImp;

    @Test
    void testCreerLivraison() {
        LivraisonDTO dtoFake = new LivraisonDTO();
        dtoFake.setStatut("EN_ATTENTE");

        when(livraisonMapper.toEntity(any())).thenReturn(new Livraison());
        when(livraisonRepository.save(any())).thenReturn(new Livraison());
        when(livraisonMapper.toDTO(any())).thenReturn(dtoFake);

        LivraisonDTO result = livraisonServiceImp.createLivraison(new LivraisonDTO());
        
        assertNotNull(result);
        assertEquals("EN_ATTENTE", result.getStatut());
        verify(livraisonRepository).save(any());
    }

    @Test
    void testAssignerChauffeurEtVehicule() {
        when(livraisonRepository.findById(1L)).thenReturn(Optional.of(new Livraison()));
        when(chauffeurRepository.findById(2L)).thenReturn(Optional.of(new Chauffeur()));
        when(vehiculeRepository.findById(3L)).thenReturn(Optional.of(new Vehicule()));
        when(livraisonRepository.save(any())).thenReturn(new Livraison());
        
        LivraisonDTO dtoResultat = new LivraisonDTO();
        dtoResultat.setChauffeurId(2L);
        dtoResultat.setVehiculeId(3L);
        when(livraisonMapper.toDTO(any())).thenReturn(dtoResultat);

        livraisonServiceImp.assignChauffeur(1L, 2L);
        LivraisonDTO result = livraisonServiceImp.assignVehicule(1L, 3L);

        assertEquals(2L, result.getChauffeurId());
        assertEquals(3L, result.getVehiculeId());
        verify(livraisonRepository, times(2)).save(any());
    }

    @Test
    void testModifierStatut() {
        when(livraisonRepository.findById(1L)).thenReturn(Optional.of(new Livraison()));
        when(livraisonRepository.save(any())).thenReturn(new Livraison());
        
        LivraisonDTO dtoStatut = new LivraisonDTO();
        dtoStatut.setStatut("LIVREE");
        when(livraisonMapper.toDTO(any())).thenReturn(dtoStatut);

        LivraisonDTO result = livraisonServiceImp.updateStatut(1L, "LIVREE");
        
        assertNotNull(result);
        assertEquals("LIVREE", result.getStatut());
        verify(livraisonRepository).save(any());
    }
}
