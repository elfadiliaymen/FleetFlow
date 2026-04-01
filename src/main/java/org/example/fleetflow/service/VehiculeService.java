package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.entity.Client;
import org.example.fleetflow.entity.Vehicule;
import org.example.fleetflow.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VehiculeService {
    private VehiculeRepository vehiculeRepository;

public Vehicule ajouterVehicule(Vehicule vehicule){
    return vehiculeRepository.save(vehicule);
}
public Vehicule modifierVehicule(long id,String nvMatricule,String nvType,Double nvCapacite,String nvStatut){
    Vehicule nvVehicule=vehiculeRepository.findById(id).orElseThrow();
    nvVehicule.setCapacite(nvCapacite);
    nvVehicule.setType(nvType);
    nvVehicule.setStatut(nvStatut);
    nvVehicule.setMatricule(nvMatricule);
    return nvVehicule;

}
public void SupprimerClient(long id){
    vehiculeRepository.deleteById(id);
}
public  final String DISPONIBLE="disponible";
public List<Vehicule>getVehiculeDisponibles(){
    return vehiculeRepository.findByStatut(DISPONIBLE);

}
public List<Vehicule>getVehiculeByStatut(String statut){
    return vehiculeRepository.findByStatut(statut);

}
public List<Vehicule>getVehiculesCapaciteInferieur(Double capacite ){
    return vehiculeRepository.findByCapaciteGreaterThan(capacite);
}


}


