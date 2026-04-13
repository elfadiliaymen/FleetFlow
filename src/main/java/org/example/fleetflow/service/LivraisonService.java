package org.example.fleetflow.service;

import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.model.Livraison;
import org.example.fleetflow.model.Vehicule;
import org.example.fleetflow.dto.LivraisonDTO;
import org.example.fleetflow.mapper.LivraisonMapper;
import org.example.fleetflow.repository.ChauffeurRepository;
import org.example.fleetflow.repository.ClientRepository;
import org.example.fleetflow.repository.LivraisonRepository;
import org.example.fleetflow.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;
    private final ChauffeurRepository chauffeurRepository;
    private final ClientRepository clientRepository;
    private final VehiculeRepository vehiculeRepository;
    private final LivraisonMapper livraisonMapper;

    public LivraisonDTO createLivraison(LivraisonDTO livraisonDTO) {
        Livraison livraison = livraisonMapper.toEntity(livraisonDTO);
        
        if (livraisonDTO.getChauffeurId() != null) {
            Chauffeur chauffeur = chauffeurRepository.findById(livraisonDTO.getChauffeurId())
                    .orElseThrow(() -> new RuntimeException("Chauffeur not found"));
            livraison.setChauffeur(chauffeur);
        }
        
        if (livraisonDTO.getClientId() != null) {
            Client client = clientRepository.findById(livraisonDTO.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            livraison.setClient(client);
        }
        
        if (livraisonDTO.getVehiculeId() != null) {
            Vehicule vehicule = vehiculeRepository.findById(livraisonDTO.getVehiculeId())
                    .orElseThrow(() -> new RuntimeException("Vehicule not found"));
            livraison.setVehicule(vehicule);
        }

        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    public LivraisonDTO updateStatut(Long id, String statut) {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livraison not found"));
        livraison.setStatut(statut);
        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    public LivraisonDTO assignChauffeur(Long livraisonId, Long chauffeurId) {
        Livraison livraison = livraisonRepository.findById(livraisonId)
                .orElseThrow(() -> new RuntimeException("Livraison not found"));
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId)
                .orElseThrow(() -> new RuntimeException("Chauffeur not found"));
        
        livraison.setChauffeur(chauffeur);
        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    public LivraisonDTO assignVehicule(Long livraisonId, Long vehiculeId) {
        Livraison livraison = livraisonRepository.findById(livraisonId)
                .orElseThrow(() -> new RuntimeException("Livraison not found"));
        Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new RuntimeException("Vehicule not found"));

        livraison.setVehicule(vehicule);
        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    public List<LivraisonDTO> getAllLivraisons() {
        return livraisonMapper.toDTOList(livraisonRepository.findAll());
    }

    public List<LivraisonDTO> getByStatut(String statut) {
        return livraisonMapper.toDTOList(livraisonRepository.findByStatut(statut));
    }

    public List<LivraisonDTO> getBetweenDates(LocalDateTime start, LocalDateTime end) {
        return livraisonMapper.toDTOList(livraisonRepository.findLivraisonsBetweenDates(start, end));
    }

    public List<LivraisonDTO> getByVille(String ville) {
        return livraisonMapper.toDTOList(livraisonRepository.findLivraisonsByVilleDestination(ville));
    }

    public List<LivraisonDTO> getByChauffeur(Long chauffeurId) {
        return livraisonMapper.toDTOList(livraisonRepository.findByChauffeurId(chauffeurId));
    }

    public List<LivraisonDTO> getByClient(Long clientId) {
        return livraisonMapper.toDTOList(livraisonRepository.findByClientId(clientId));
    }

    //
    public List<LivraisonDTO>getLivraisonByVille(String ville){
        return livraisonMapper.toDTOList(livraisonRepository.findByVille(ville));
    }
}
