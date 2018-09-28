package com.manutencao.learnenglish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencao.learnenglish.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	List<Module> findByCouserId(Long couserId);
}
