package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.config.KeycloakUtil;
import com.eam.Fixed.Assets.dto.UsersDto;
import com.eam.Fixed.Assets.service.KeycloakService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
@AllArgsConstructor
@Transactional
public class Keycloakimpl implements KeycloakService {
    @Autowired
    private KeycloakPasswordimpl keycloakPasswordimpl;

    public boolean createKeycloakUser(UsersDto usersDto){
        try{
            UserRepresentation user = new UserRepresentation();
            user.setUsername(usersDto.getEmpId());
            user.setEmail(usersDto.getEmail());
            user.setFirstName(usersDto.getEmpName());
            user.setLastName("");
            user.setCredentials(Collections.singletonList(keycloakPasswordimpl.passwordCredentials(usersDto.getPassword())));

            Response response = KeycloakUtil.getKeycloakInstance().realm(KeycloakUtil.getRealm()).users().create(user);
            return response.getStatus() == 200 || response.getStatus() == 201;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
