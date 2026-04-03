package org.example.fleetflow.mapper;

import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.dto.ChauffeurDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {
    ChauffeurDTO toDTO(Chauffeur chauffeur);
    Chauffeur toEntity(ChauffeurDTO chauffeurDTO);
    List<ChauffeurDTO> toDTOs(List<Chauffeur> chauffeurs);
    List<Chauffeur> toEntities(List<ChauffeurDTO> chauffeurDTOs);
}
