package org.example.fleetflow.services;

import org.example.fleetflow.dto.ChauffeurDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChauffeurService {
     List<ChauffeurDTO> getAvailableChauffeurs();
    List<ChauffeurDTO> getAllChauffeurs();
     ChauffeurDTO addChauffeur(ChauffeurDTO chauffeurDTO);
     ChauffeurDTO updateChauffeur(Long id, ChauffeurDTO chauffeurDTO);
     void deleteChauffeur(Long id);
     List<ChauffeurDTO> getByPermisType(String permisType);
     Page<ChauffeurDTO> chauffeursTriesEtPagines(int page, int size, String sortBy, String destination);
}
