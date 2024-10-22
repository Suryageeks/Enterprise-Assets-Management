package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.config.OidcUserConfig;
import com.eam.Fixed.Assets.service.UserRoleSolService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class OidcUserimpl extends OidcUserService {
    @Autowired
    private UserRoleSolService userRoleSolService;
    @Override
    public OidcUser loadUser(OidcUserRequest oidcUserRequest){
        OidcUser oidcUser = super.loadUser(oidcUserRequest);
        String username = oidcUser.getPreferredUsername();
        Map<String, Object> userDetails = userRoleSolService.getUserDetails(username);
        String solid = (String) userDetails.get("sol_id");
        String rolename = (String) userDetails.get("role_name");

        return new OidcUserConfig(oidcUser,solid,rolename);
    }
}
