package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.RolesDto;
import com.eam.Fixed.Assets.service.RolesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("login/oauth2/code/api/roles")
public class RolesController{
    private RolesService rolesService;

    @PostMapping
    public ResponseEntity<RolesDto> createRole(@Valid @RequestBody RolesDto roles){
        RolesDto saveRole = rolesService.createRole(roles);
        return new ResponseEntity<>(saveRole, HttpStatus.CREATED);
    }
    @GetMapping("allroles")
    public ResponseEntity<List<RolesDto>> getAllRoles(){
        List<RolesDto> allRoles = rolesService.getAllRoles();
        return new ResponseEntity<>(allRoles,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<RolesDto> getRole(@PathVariable("id") Long id){
        RolesDto specificRole = rolesService.getRoleById(id);
        return new ResponseEntity<>(specificRole,HttpStatus.OK);
    }
}
