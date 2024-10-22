package com.eam.Fixed.Assets.security;

import com.eam.Fixed.Assets.config.OidcUserConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OidcUserConfig oidcUser = (OidcUserConfig) authentication.getPrincipal();
        HttpSession session = request.getSession();
        session.setAttribute("sol_id",oidcUser.getSolId());
        session.setAttribute("rolename",oidcUser.getRoles());
        response.sendRedirect("/api/user/login");
    }
}
