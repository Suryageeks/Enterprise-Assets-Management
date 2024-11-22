package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.RolesDto;
import com.eam.Fixed.Assets.entity.Roles;
import com.eam.Fixed.Assets.repository.RolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RolesimplTest {
    @InjectMocks
    private Rolesimpl rolesimpl;
    @Mock
    private RolesRepository rolesRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createRole() {
        RolesDto role = new RolesDto(1L,"Admin");
        Roles saveRole = new Roles(1L,"Admin",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
              rolesRepository.save(any(Roles.class))
        ).thenReturn(saveRole);
        RolesDto createRole = rolesimpl.createRole(role);
        assertNotNull(createRole);
        assertEquals(saveRole.getRoleName(), createRole.getRoleName());
        assertEquals(saveRole.getRoleId(), createRole.getRoleId());
    }

    @Test
    void getAllRoles() {
        Roles role = new Roles(1L,"Maker",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        Roles role2 = new Roles(2L,"Checker",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
                rolesRepository.findAll()
        ).thenReturn(Arrays.asList(role,role2));
        List<RolesDto> allRoles = rolesimpl.getAllRoles();
        assertNotNull(allRoles);
        assertEquals(allRoles.size(), 2);
        assertEquals(allRoles.get(0).getRoleName(), role.getRoleName());
        verify(rolesRepository,times(1)).findAll();
    }

    @Test
    void getRoleById() {
        Roles role = new Roles(1L,"Maker",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(rolesRepository.findById(1L)).thenReturn(Optional.of(role));

        RolesDto fetchRole = rolesimpl.getRoleById(1L);
        assertNotNull(fetchRole);
        assertEquals(fetchRole.getRoleName(), role.getRoleName());
        verify(rolesRepository,times(1)).findById(1L);
    }
}