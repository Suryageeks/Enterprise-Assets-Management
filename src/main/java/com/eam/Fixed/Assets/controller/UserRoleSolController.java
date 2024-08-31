package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.UserRoleSolDto;
import com.eam.Fixed.Assets.service.UserRoleSolService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mapping")
public class UserRoleSolController {

    private UserRoleSolService userRoleSolService;

    @PostMapping("/create")
    public ResponseEntity<UserRoleSolDto> createMapping(@RequestBody UserRoleSolDto userRoleSolDto){
        UserRoleSolDto data = userRoleSolService.mapUsers(userRoleSolDto);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserRoleSolDto>> allMapping(){
        List<UserRoleSolDto> users = userRoleSolService.getData();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<UserRoleSolDto> getMappingByIdOrName(@PathVariable("id") String idOrName){
        UserRoleSolDto user = userRoleSolService.getUserByIdOrName(idOrName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
