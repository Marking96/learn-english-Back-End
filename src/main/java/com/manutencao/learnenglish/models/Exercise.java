package com.manutencao.learnenglish.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

@Entity
@Table(name="exercises")
public class Exercise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="exercise", targetEntity=Alternative.class, fetch = FetchType.LAZY)
	private List<Alternative> alternatives;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="modules_id")
	private Module modules;
	
	// Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Alternative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<Alternative> alternatives) {
		this.alternatives = alternatives;
	}

	public Module getModules() {
		return modules;
	}

	public void setModules(Module modules) {
		this.modules = modules;
	}

	
	

}
