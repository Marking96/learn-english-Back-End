package com.manutencao.learnenglish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.manutencao.learnenglish.models.FileUpload;

public interface FileRepository extends JpaRepository<FileUpload, Long> {
	
	//@Transactional
	//FileUpload findByNameFile(String name);
}
