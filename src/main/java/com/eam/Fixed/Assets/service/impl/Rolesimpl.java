package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.RolesDto;
import com.eam.Fixed.Assets.entity.Roles;
import com.eam.Fixed.Assets.mapper.RoleMapper;
import com.eam.Fixed.Assets.repository.RolesRepository;
import com.eam.Fixed.Assets.service.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Rolesimpl implements RolesService {

    private RolesRepository rolesRepository;
    @Override
    public RolesDto createRole(RolesDto rolesDto) {
        Roles roles = RoleMapper.MAPPER.mapToRole(rolesDto);

        Roles savedRole = rolesRepository.save(roles);

        RolesDto saveInDb = RoleMapper.MAPPER.mapToRoleDto(savedRole);

        return saveInDb;
    }

    @Override
    public List<RolesDto> getAllRoles() {
        List<Roles> roles = rolesRepository.findAll();

        return roles.stream().map(val -> RoleMapper.MAPPER.mapToRoleDto(val)).collect(Collectors.toList());
    }

    @Override
    public RolesDto getRoleById(Long Id) {
        Roles getRole = rolesRepository.findById(Id).orElseThrow(() -> new RuntimeException("ID not present"));
        return RoleMapper.MAPPER.mapToRoleDto(getRole);
    }
}
