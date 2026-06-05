package org.example.fleetflow.services;

import org.example.fleetflow.dto.LivraisonDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface LivraisonService {
    LivraisonDTO createLivraison(LivraisonDTO livraisonDTO);
    LivraisonDTO updateStatut(Long id, String statut);
    LivraisonDTO assignChauffeur(Long livraisonId, Long chauffeurId);
    LivraisonDTO assignVehicule(Long livraisonId, Long vehiculeId);
    List<LivraisonDTO> getAllLivraisons();
    List<LivraisonDTO> getByStatut(String statut);
    List<LivraisonDTO> getBetweenDates(LocalDateTime start, LocalDateTime end);
    List<LivraisonDTO> getByVille(String ville);
    List<LivraisonDTO> getByChauffeur(Long chauffeurId);
    List<LivraisonDTO> getByClient(Long clientId);
    Page<LivraisonDTO> livraisonTriesEtPagines(int page, int size, String sortBy, String destination);
}
