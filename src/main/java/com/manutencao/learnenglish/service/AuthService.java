package com.manutencao.learnenglish.service;

import com.manutencao.learnenglish.Exception.UserNoTFoundException;
import com.manutencao.learnenglish.models.User;
import com.manutencao.learnenglish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void sendNewPassword(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserNoTFoundException("User Not Found with" + email);
        }
        String newPass = newPassword();
        user.setPassword(bCryptPasswordEncoder.encode(newPass));

        userRepository.save(user);
    }
}
