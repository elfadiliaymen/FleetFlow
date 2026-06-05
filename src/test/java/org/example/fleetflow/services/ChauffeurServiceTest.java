package org.example.fleetflow.services;

import org.example.fleetflow.dto.ChauffeurDTO;
import org.example.fleetflow.mapper.ChauffeurMapper;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.repository.ChauffeurRepository;
import org.example.fleetflow.services.imp.ChauffeurServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChauffeurServiceTest {

    @Mock
    private ChauffeurRepository chauffeurRepository;

    @Mock
    private ChauffeurMapper chauffeurMapper;

    @InjectMocks
    private ChauffeurServiceImp chauffeurServiceImp;

    @Test
    void testListerChauffeursDisponibles() {
        Chauffeur c = new Chauffeur();
        ChauffeurDTO dto = new ChauffeurDTO();
        
        when(chauffeurRepository.findByDisponibleTrue()).thenReturn(List.of(c));
        when(chauffeurMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<ChauffeurDTO> result = chauffeurServiceImp.getAvailableChauffeurs();
        
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(chauffeurRepository).findByDisponibleTrue();
    }
}
