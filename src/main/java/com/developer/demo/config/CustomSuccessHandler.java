/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author hope
 */
@Configuration
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException{
        
        String targetUrl = determineTargetUrl(authentication);
        if(response.isCommitted()){
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    
    protected String determineTargetUrl(Authentication authentication){
        String url = "/login?error=true";
        
        //Fetch roles from Authentication object
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();
        for (GrantedAuthority a : authorities){
            roles.add(a.getAuthority());
        }
        
        //check user role and decide redirect url
        if(roles.contains("Human Resources Manager")){
            url = "/hrmanager";
        }
        else if (roles.contains("Supervisor")){
            url = "/supervisor";
        }
        else{
            url = "/employee";
        }
        
        return url;
    }
}
