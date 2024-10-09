package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.UsersDto;

public interface KeycloakService {
    public boolean createKeycloakUser(UsersDto usersDto);
}
