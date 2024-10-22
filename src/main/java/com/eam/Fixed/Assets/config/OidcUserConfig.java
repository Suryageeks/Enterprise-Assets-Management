package com.eam.Fixed.Assets.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Collection;
import java.util.Map;

public class OidcUserConfig implements OidcUser {
    private OidcUser oidcUser;
    private String solId;
    private String roles;
    public OidcUserConfig(OidcUser oidcUser, String solId, String roles) {
        this.oidcUser = oidcUser;
        this.solId = solId;
        this.roles = roles;
    }
    public String getSolId() {
        return solId;
    }
    public String getRoles() {
        return roles;
    }
    @Override
    public Map<String, Object> getClaims() {
        return oidcUser.getClaims();
    }

    @Override
    public OidcUserInfo getUserInfo() {
        return oidcUser.getUserInfo();
    }

    @Override
    public OidcIdToken getIdToken() {
        return oidcUser.getIdToken();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oidcUser.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oidcUser.getAuthorities();
    }

    @Override
    public String getName() {
        return oidcUser.getName();
    }
}
