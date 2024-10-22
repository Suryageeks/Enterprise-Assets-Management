package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.UserRoleSolDto;

import java.util.List;
import java.util.Map;

public interface UserRoleSolService {
    UserRoleSolDto mapUsers(UserRoleSolDto users);

    List<UserRoleSolDto> getData();

    UserRoleSolDto getUserByIdOrName(String idOrName);
    public Map<String, Object> getUserDetails(String username);

//    UserRoleSolDto updateDetails(String idOrName, UserRoleSolDto details);
}
