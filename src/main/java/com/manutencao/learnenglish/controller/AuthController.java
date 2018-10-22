package com.manutencao.learnenglish.controller;

import com.manutencao.learnenglish.jwtSecurity.JWTUtil;
import com.manutencao.learnenglish.jwtSecurity.UserSecurity;
import com.manutencao.learnenglish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping(value = "/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response){
        UserSecurity user = UserService.isAuthenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers","Authorization");
        return ResponseEntity.noContent().build();
    }
}
