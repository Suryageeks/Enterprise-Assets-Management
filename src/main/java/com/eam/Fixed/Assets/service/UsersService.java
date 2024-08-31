package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.UsersDto;

import java.util.List;

public interface UsersService {
    UsersDto createUser(UsersDto usersDto);

    UsersDto getUserByEmpId(String empId);

    List<UsersDto> listUsers();

    String deleteUser(String empId);

    UsersDto updateUserDetails(String empId,UsersDto usersDto);

    String getStatus(String empId);
}

