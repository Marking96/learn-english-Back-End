package com.manutencao.learnenglish.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencao.learnenglish.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findById(long id);

}
