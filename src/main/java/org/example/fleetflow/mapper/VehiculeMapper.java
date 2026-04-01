package org.example.fleetflow.mapper;

import org.example.fleetflow.dto.VehiculeDTO;
import org.example.fleetflow.entity.Client;
import org.example.fleetflow.entity.Vehicule;

import java.util.List;

public interface VehiculeMapper {
    VehiculeDTO toDTO(Vehicule vehicule);
    Vehicule toEntity(VehiculeDTO vehicule);
    List<VehiculeDTO>toDTOList(List<Vehicule>vehicules);

}
