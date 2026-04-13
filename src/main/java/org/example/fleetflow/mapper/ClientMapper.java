package org.example.fleetflow.mapper;

import org.example.fleetflow.dto.ClientDTO;
import org.example.fleetflow.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
    List<ClientDTO>toDTOList(List<Client>clients);
}
