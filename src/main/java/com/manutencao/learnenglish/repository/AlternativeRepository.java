/**
 * 
 */
package com.manutencao.learnenglish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencao.learnenglish.models.Alternative;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */
public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

}
