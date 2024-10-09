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
public class KeycloakUtil {
    static Keycloak keycloak;
    @Value("${server_uri}")
    private static String serverUrl;
    @Value("${realm}")
    private static String realm;
    @Value("${name}")
    private static String username;
    @Value("${password}")
    private static String password;
    @Value("${grant-type}")
    private static String grantType;
    @Value("${client-id}")
    private static String clientID;

    public static Keycloak getKeycloakInstance(){
        if(keycloak==null){
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl).realm(realm).username(username).password(password)
                    .grantType(grantType).clientId(clientID).build();
        }
        return keycloak;
    }

    public static String getRealm(){
        return realm;
    }

}
