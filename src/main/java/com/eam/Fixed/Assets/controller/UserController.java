package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.UsersDto;
import com.eam.Fixed.Assets.service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<UsersDto> createUser(@Valid @RequestBody UsersDto usersDto){
        UsersDto saveUser = usersService.createUser(usersDto);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable("id") String empId){
        UsersDto getUser = usersService.getUserByEmpId(empId);
        return new ResponseEntity<>(getUser,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        List<UsersDto> listUsers = usersService.listUsers();
        return new ResponseEntity<>(listUsers,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String empId){
        usersService.deleteUser(empId);
        return ResponseEntity.ok("User Deleted Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUserDetails(@PathVariable("id") String empId,@RequestBody UsersDto usersDto){
        UsersDto user = usersService.updateUserDetails(empId,usersDto);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> getStatus(@PathVariable("id") String empId){
        String user = usersService.getStatus(empId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
