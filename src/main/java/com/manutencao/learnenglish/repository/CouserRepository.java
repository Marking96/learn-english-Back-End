package com.manutencao.learnenglish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencao.learnenglish.models.Couser;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

public interface CouserRepository  extends JpaRepository<Couser, Long>{
	
	

}
