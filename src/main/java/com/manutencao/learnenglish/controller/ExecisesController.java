package com.manutencao.learnenglish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutencao.learnenglish.models.Alternative;
import com.manutencao.learnenglish.models.Exercise;
import com.manutencao.learnenglish.models.Module;
import com.manutencao.learnenglish.repository.AlternativeRepository;
import com.manutencao.learnenglish.repository.ExercisesRepository;
import com.manutencao.learnenglish.repository.ModuleRepository;


/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

@RestController
@RequestMapping(value="/exercise")
public class ExecisesController {
	
	@Autowired
	ExercisesRepository exercisesRepository;
	
	@Autowired
	AlternativeRepository alternativeRepository;
	
	@Autowired
	ModuleRepository moduleRepository;

	@PostMapping("/exercise/{id}")
	public Exercise saveExercise(@PathVariable(value="id") long id, @RequestBody Exercise exercise) {
		Module module = moduleRepository.getOne(id);
		exercise.setModules(module);
		return exercisesRepository.save(exercise);
	}
	
	@GetMapping("/exercise/{module_id}")
	public List<Exercise> listExercise (@PathVariable(value="module_id") long modulesid){
		return exercisesRepository.findByModulesId(modulesid);
	}
	
	public Alternative ssaveAternative(@PathVariable(value="id") long id, @RequestBody Alternative alternative) {
		Optional<Exercise> excercise = exercisesRepository.findById(id);
		alternative.setExercise(excercise.get());
		return alternativeRepository.save(alternative);
	}
}

