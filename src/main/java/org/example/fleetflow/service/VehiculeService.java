package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.dto.ChauffeurDTO;
import org.example.fleetflow.dto.VehiculeDTO;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Vehicule;
import org.example.fleetflow.mapper.VehiculeMapper;
import org.example.fleetflow.repository.ClientRepository;
import org.example.fleetflow.repository.VehiculeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

public VehiculeDTO ajouterVehicule(VehiculeDTO vehiculeDTO){
    Vehicule vehicule=vehiculeMapper.toEntity(vehiculeDTO);
    Vehicule savedVehicule=vehiculeRepository.save(vehicule);

    return vehiculeMapper.toDTO(savedVehicule);
}
public List<VehiculeDTO> getAllVehicules(){
    return vehiculeMapper.toDTOList(vehiculeRepository.findAll());
}
public VehiculeDTO modifierVehicule(long id,VehiculeDTO  vehiculeDTO){
    Vehicule nvVehicule=vehiculeRepository.findById(id).orElseThrow();
    nvVehicule.setCapacite(vehiculeDTO.getCapacite());
    nvVehicule.setType(vehiculeDTO.getType());
    nvVehicule.setStatut(vehiculeDTO.getStatut());
    nvVehicule.setMatricule(vehiculeDTO.getMatricule());
    Vehicule updateVehicule=vehiculeRepository.save(nvVehicule);
    return vehiculeMapper.toDTO(updateVehicule);

}
public void SupprimerVehicule(long id){
    vehiculeRepository.deleteById(id);
}
public  final String DISPONIBLE="disponible";
public List<VehiculeDTO>getVehiculeDisponibles(){
    return vehiculeMapper.toDTOList(vehiculeRepository.findByStatut(DISPONIBLE));

}
public List<VehiculeDTO>getVehiculeByStatut(String statut){
    return vehiculeMapper.toDTOList(vehiculeRepository.findByStatut(statut));

}
public List<VehiculeDTO>getVehiculesCapaciteSuperieur(double capacite ){
    return  vehiculeMapper.toDTOList(vehiculeRepository.findByCapaciteGreaterThan(capacite));
}
    public Page<VehiculeDTO> vehiculesTriesEtPagines(int page, int size, String sortBy, String destination){
        Sort sort=destination.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Vehicule> vehicules=vehiculeRepository.findAll(pageable);
        return vehicules.map(vehiculeMapper::toDTO);


    }

}


