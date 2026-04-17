package org.example.fleetflow.service;

import org.example.fleetflow.dto.LivraisonDTO;
import org.example.fleetflow.mapper.LivraisonMapper;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Livraison;
import org.example.fleetflow.model.Vehicule;
import org.example.fleetflow.repository.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LivraisonServiceTest {

    @Test
    void testCreerLivraison() {

        LivraisonRepository repo = mock(LivraisonRepository.class);
        LivraisonMapper mapper = mock(LivraisonMapper.class);
        LivraisonService service = new LivraisonService(
            repo, 
            mock(ChauffeurRepository.class), 
            mock(ClientRepository.class), 
            mock(VehiculeRepository.class), 
            mapper
        );


        LivraisonDTO dtoFake = new LivraisonDTO();
        dtoFake.setStatut("EN_ATTENTE");

        when(mapper.toEntity(any())).thenReturn(new Livraison());
        when(repo.save(any())).thenReturn(new Livraison());
        when(mapper.toDTO(any())).thenReturn(dtoFake);


        LivraisonDTO result = service.createLivraison(new LivraisonDTO());
        assertEquals("EN_ATTENTE", result.getStatut());
    }

    @Test
    void testAssignerChauffeurEtVehicule() {

        LivraisonRepository repo = mock(LivraisonRepository.class);
        ChauffeurRepository chauffeurRepo = mock(ChauffeurRepository.class);
        VehiculeRepository vehiculeRepo = mock(VehiculeRepository.class);
        LivraisonMapper mapper = mock(LivraisonMapper.class);
        LivraisonService service = new LivraisonService(
            repo, 
            chauffeurRepo, 
            mock(ClientRepository.class), 
            vehiculeRepo, 
            mapper
        );


        when(repo.findById(1L)).thenReturn(Optional.of(new Livraison()));
        when(chauffeurRepo.findById(2L)).thenReturn(Optional.of(new Chauffeur()));
        when(vehiculeRepo.findById(3L)).thenReturn(Optional.of(new Vehicule()));
        when(repo.save(any())).thenReturn(new Livraison());
        
        LivraisonDTO dtoResultat = new LivraisonDTO();
        dtoResultat.setChauffeurId(2L);
        dtoResultat.setVehiculeId(3L);
        when(mapper.toDTO(any())).thenReturn(dtoResultat);


        service.assignChauffeur(1L, 2L); // Assigner chauffeur
        LivraisonDTO result = service.assignVehicule(1L, 3L); // Assigner vehicule

        assertEquals(2L, result.getChauffeurId());
        assertEquals(3L, result.getVehiculeId());
    }

    @Test
    void testModifierStatut() {

        LivraisonRepository repo = mock(LivraisonRepository.class);
        LivraisonMapper mapper = mock(LivraisonMapper.class);
        LivraisonService service = new LivraisonService(
            repo, 
            mock(ChauffeurRepository.class), 
            mock(ClientRepository.class), 
            mock(VehiculeRepository.class), 
            mapper
        );


        when(repo.findById(1L)).thenReturn(Optional.of(new Livraison()));
        when(repo.save(any())).thenReturn(new Livraison());
        
        LivraisonDTO dtoStatut = new LivraisonDTO();
        dtoStatut.setStatut("LIVREE");
        when(mapper.toDTO(any())).thenReturn(dtoStatut);


        LivraisonDTO result = service.updateStatut(1L, "LIVREE");
        assertEquals("LIVREE", result.getStatut());
    }
}
