package com.manutencao.learnenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manutencao.learnenglish.models.Couser;
import com.manutencao.learnenglish.models.Module;
import com.manutencao.learnenglish.repository.CouserRepository;
import com.manutencao.learnenglish.repository.ModuleRepository;

@RestController
@RequestMapping(value="/module")
public class ModuleController {
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CouserRepository couserRepository;
	
	@PostMapping("/module/{id}")
	public Module saveModule(@PathVariable(value="id") long id , @RequestBody Module module) {
		Couser couser = couserRepository.getOne(id); 
		module.setCouser(couser);
		return moduleRepository.save(module);
		
	}
	@GetMapping("/modules/{couse_id}")
	public List<Module> listModule(@PathVariable(value="couse_id") long couseId ){
		return moduleRepository.findByCouserId(couseId);
	}

}
