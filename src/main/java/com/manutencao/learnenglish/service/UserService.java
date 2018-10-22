package com.manutencao.learnenglish.service;

import com.manutencao.learnenglish.jwtSecurity.UserSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {
    public static UserSecurity isAuthenticated ( ) {
        try {
            return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e){
            return null;
        }
    }
}
