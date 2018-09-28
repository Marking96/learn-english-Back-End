package com.manutencao.learnenglish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencao.learnenglish.models.Exercise;


public interface ExercisesRepository extends JpaRepository<Exercise, Long> {
	
	List<Exercise> findByModulesId(Long modulesid);
}
