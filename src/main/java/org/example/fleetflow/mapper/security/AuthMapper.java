package org.example.fleetflow.mapper.security;

import org.example.fleetflow.dto.userdto.RegisterUser;
import org.example.fleetflow.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface AuthMapper {
    @Mapping(target="id",ignore = true)
    @Mapping(target = "role",ignore = true)
    User toEntity(RegisterUser user);
}
