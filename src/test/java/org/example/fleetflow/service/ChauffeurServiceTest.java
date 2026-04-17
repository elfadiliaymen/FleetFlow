package org.example.fleetflow.service;

import org.example.fleetflow.dto.ChauffeurDTO;
import org.example.fleetflow.mapper.ChauffeurMapper;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.repository.ChauffeurRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChauffeurServiceTest {

    @Test
    void testListerChauffeursDisponibles() {

        ChauffeurRepository repo = mock(ChauffeurRepository.class);
        ChauffeurMapper mapper = mock(ChauffeurMapper.class);
        ChauffeurService service = new ChauffeurService(repo, mapper);


        Chauffeur c = new Chauffeur();
        when(repo.findByDisponibleTrue()).thenReturn(List.of(c));
        when(mapper.toDTOList(any())).thenReturn(List.of(new ChauffeurDTO()));


        List<ChauffeurDTO> result = service.getAvailableChauffeurs();
        assertEquals(1, result.size());
    }
}
