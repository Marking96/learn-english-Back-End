package com.manutencao.learnenglish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manutencao.learnenglish.models.User;
import com.manutencao.learnenglish.repository.UserRepository;
import com.manutencao.learnenglish.security.UserSecurity;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		System.out.println(user.getUsername() +"  "+ user.getPassword());
		return new UserSecurity(user.getId(),user.getUsername(), user.getPassword(), user.getType());
	}

}
