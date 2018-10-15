package com.manutencao.learnenglish.jwtSecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manutencao.learnenglish.Exception.UsernameOrPasswordIncorrectException;
import com.manutencao.learnenglish.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

public class JWTAuthenticationFilter extends  UsernamePasswordAuthenticationFilter  {

    private AuthenticationManager authenticationManager;

    private JWTUtil jwtUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) {

        try {
            User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(),
                    user.getPassword(), new ArrayList<>());

            Authentication auth = authenticationManager.authenticate(authToken);
            System.out.println(auth);
            if (!auth.isAuthenticated()){
                throw  new UsernameOrPasswordIncorrectException("UserName ou Password Incorret");
            }
            return auth;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String username = ((UserSecurity) authResult.getPrincipal()).getUsername();
        String token = jwtUtil.generateToken(username);
        response.addHeader("Authorization", "Bearer " + token);
        response.setHeader("Authorization", "Bearer " + token);
        response.addHeader("username", username);
    }

}