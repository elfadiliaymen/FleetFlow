package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.dto.VehiculeDTO;
import org.example.fleetflow.model.Vehicule;
import org.example.fleetflow.mapper.VehiculeMapper;
import org.example.fleetflow.repository.ClientRepository;
import org.example.fleetflow.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VehiculeService {
    private final ClientRepository clientRepository;
    private VehiculeRepository vehiculeRepository;
    private VehiculeMapper vehiculeMapper;

public VehiculeDTO ajouterVehicule(VehiculeDTO vehiculeDTO){
    Vehicule vehicule=vehiculeMapper.toEntity(vehiculeDTO);
    Vehicule savedVehicule=vehiculeRepository.save(vehicule);

    return vehiculeMapper.toDTO(savedVehicule);
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
public List<VehiculeDTO>getVehiculesCapaciteSuperieur(Double capacite ){
    return  vehiculeMapper.toDTOList(vehiculeRepository.findByCapaciteGreaterThan(capacite));
}


}


