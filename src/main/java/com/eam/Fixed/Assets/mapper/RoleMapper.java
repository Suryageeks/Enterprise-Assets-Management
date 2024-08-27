package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.RolesDto;
import com.eam.Fixed.Assets.entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

    RolesDto mapToRoleDto(Roles roles);

    Roles mapToRole(RolesDto rolesDto);
}
