package com.eam.Fixed.Assets.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakUtil {
    Keycloak keycloak;
    @Value("${server_uri}")
    private String serverUrl;
    @Value("${realm}")
    private String realm;
    @Value("${name}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${grant-type}")
    private String grantType;
    @Value("${client-id}")
    private String clientID;

    public Keycloak getKeycloakInstance(){
        if(keycloak==null){
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl).realm(realm).username(username).password(password)
                    .grantType(grantType).clientId(clientID).build();
        }
        return keycloak;
    }

}
