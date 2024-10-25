package com.eam.Fixed.Assets.security;

import com.eam.Fixed.Assets.service.UserRoleSolService;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRoleSolService userRoleSolService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = authentication.getName();
        Map<String,String> getUser = userRoleSolService.getUserDetails(username).orElse(new HashMap<>());
            session.setAttribute("username",username);
            session.setAttribute("solid",getUser.get("sol_id"));
            session.setAttribute("role",getUser.get("role"));
        response.sendRedirect("api/roles/allroles");
    }
}