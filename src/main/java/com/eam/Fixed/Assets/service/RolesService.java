package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.RolesDto;

import java.util.List;

public interface RolesService {

    RolesDto createRole(RolesDto rolesDto);

    List<RolesDto> getAllRoles();

    RolesDto getRoleById(Long Id);
}
