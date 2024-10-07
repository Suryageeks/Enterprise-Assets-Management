package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.config.KeycloakUtil;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class Keycloakimpl {
    @Autowired
    private KeycloakUtil keycloakUtil;

    public boolean createKeycloakUser(String name,String email,String password){
        RealmResource realmResource = keycloakUtil.getKeycloakInstance().realm(keycloakUtil.getRealm());
        UserResource userResource = realmResource.users();

        UserRepresentation user = new UserRepresentation();
        user.setUsername(name);
        user.setEmail(email);
        user.setCredentials(Collections.singletonList(passwordCredentials(password)));

//        Response response = userResource.crea
    }

    public CredentialRepresentation passwordCredentials(String password){
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password);
        return passwordCred;
    }
}
