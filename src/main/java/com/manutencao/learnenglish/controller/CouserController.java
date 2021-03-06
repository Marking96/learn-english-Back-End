package com.manutencao.learnenglish.controller;

import java.util.ArrayList;
import java.util.List;

import com.manutencao.learnenglish.Exception.CourseNotFoundException;
import com.manutencao.learnenglish.Exception.UserNoTFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manutencao.learnenglish.models.Couser;
import com.manutencao.learnenglish.models.User;
import com.manutencao.learnenglish.repository.CouserRepository;
import com.manutencao.learnenglish.repository.UserRepository;

@RestController
@RequestMapping(value="/couser")
public class CouserController {
	
	@Autowired
	CouserRepository couserRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/cousers")
	public List<Couser> listCouser() {
		return couserRepository.findAll();	
	}

    @GetMapping("/{id}")
	public Couser couserByID(@RequestParam Long id){
	    Couser couser = couserRepository.getOne(id);
	    if(couser == null ){
	        throw  new CourseNotFoundException("Couser not found for ID: "+ id);
        }
        return  couser;
	}

	@PostMapping("/couser")
	public Couser saveCouser(@RequestBody Couser couser) {
		
		List<User> instrutores = new ArrayList<>();
		for (User user: couser.getInstructor()) {
			user = userRepository.findByUsername(user.getUsername());
			if (user.equals(null)){
			    throw new UserNoTFoundException("User not found for Username");
            }
			instrutores.add(user);
		}
		couser.setInstructor(instrutores);
		return couserRepository.save(couser);
	}

}
 