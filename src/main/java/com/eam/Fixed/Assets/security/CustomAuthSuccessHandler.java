package com.eam.Fixed.Assets.security;

import com.eam.Fixed.Assets.service.UserRoleSolService;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
        OAuth2User username = (OAuth2User) authentication.getPrincipal();
        String email = (String) username.getAttributes().get("email");
        Map<String,String> getUser = userRoleSolService.getUserDetails(email).orElse(new HashMap<>());
            session.setAttribute("email",email);
            session.setAttribute("solid",getUser.get("sol_id"));
            session.setAttribute("role",getUser.get("role"));
            session.setAttribute("empid",getUser.get("emp_id"));
            session.setAttribute("empname",getUser.get("emp_name"));
            session.setAttribute("empemail",getUser.get("emp_email"));
            session.setAttribute("roleid",getUser.get("role_id"));
        response.sendRedirect("api/roles/allroles");
    }
}