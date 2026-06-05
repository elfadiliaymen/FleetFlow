package org.example.fleetflow.services.imp;

import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.dto.ChauffeurDTO;
import org.example.fleetflow.mapper.ChauffeurMapper;
import org.example.fleetflow.repository.ChauffeurRepository;
import lombok.RequiredArgsConstructor;
import org.example.fleetflow.services.ChauffeurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChauffeurServiceImp implements ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;
    private final ChauffeurMapper chauffeurMapper;

    public ChauffeurDTO addChauffeur(ChauffeurDTO chauffeurDTO) {
        Chauffeur chauffeur = chauffeurMapper.toEntity(chauffeurDTO);
        return chauffeurMapper.toDTO(chauffeurRepository.save(chauffeur));
    }

    public ChauffeurDTO updateChauffeur(Long id, ChauffeurDTO chauffeurDTO) {
        Chauffeur chauffeur = chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur not found"));
        chauffeur.setNom(chauffeurDTO.getNom());
        chauffeur.setTelephone(chauffeurDTO.getTelephone());
        chauffeur.setPermisType(chauffeurDTO.getPermisType());
        chauffeur.setDisponible(chauffeurDTO.isDisponible());
        return chauffeurMapper.toDTO(chauffeurRepository.save(chauffeur));
    }

    public void deleteChauffeur(Long id) {
        chauffeurRepository.deleteById(id);
    }

    public List<ChauffeurDTO> getAllChauffeurs() {
        return chauffeurMapper.toDTOList(chauffeurRepository.findAll());
    }

    public List<ChauffeurDTO> getAvailableChauffeurs() {
        return chauffeurMapper.toDTOList(chauffeurRepository.findByDisponibleTrue());
    }

    public List<ChauffeurDTO> getByPermisType(String permisType) {
        return chauffeurMapper.toDTOList(chauffeurRepository.findByPermisType(permisType));
    }

    public Page<ChauffeurDTO>chauffeursTriesEtPagines(int page,int size,String sortBy,String destination){
        Sort sort=destination.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Chauffeur> chauffeurs=chauffeurRepository.findAll(pageable);
        return chauffeurs.map(chauffeurMapper::toDTO);


    }
}
