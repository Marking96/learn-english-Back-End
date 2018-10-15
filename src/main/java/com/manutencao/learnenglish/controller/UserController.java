package com.manutencao.learnenglish.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutencao.learnenglish.models.User;
import com.manutencao.learnenglish.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncode;
	
	@GetMapping("/users")
	public List<User> listUser(){
		return userRepository.findAll();	
	}

	@GetMapping("/users/{id}")
	public User listUserById(@PathVariable(value="id") long id){
		return userRepository.findById(id);	
	}
	
	@PostMapping("/users")
	public User save (@RequestBody User user) {
		
		user.setPassword(passwordEncode.encode(user.getPassword()));
		return userRepository.save(user);
	}
    @GetMapping(value = "/video")
    public void video (HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:3001/movies/aula02.mp4");
    }
}
