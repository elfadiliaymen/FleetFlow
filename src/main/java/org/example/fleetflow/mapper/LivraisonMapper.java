package org.example.fleetflow.mapper;

import org.example.fleetflow.model.Livraison;
import org.example.fleetflow.dto.LivraisonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {

    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    LivraisonDTO toDTO(Livraison livraison);

    @Mapping(source = "chauffeurId", target = "chauffeur.id")
    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "vehiculeId", target = "vehicule.id")
    Livraison toEntity(LivraisonDTO livraisonDTO);

    List<LivraisonDTO> toDTOList(List<Livraison> livraisons);
    List<Livraison> toEntityList(List<LivraisonDTO> livraisonDTOs);
}
