package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.UserRoleSolDto;

import java.util.List;

public interface UserRoleSolService {
    UserRoleSolDto mapUsers(UserRoleSolDto users);

    List<UserRoleSolDto> getData();

    UserRoleSolDto getUserByIdOrName(String idOrName);

//    UserRoleSolDto updateDetails(String idOrName, UserRoleSolDto details);
}
