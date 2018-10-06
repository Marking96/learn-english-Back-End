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
@Table(name="modules")
public class Module implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String title;
	
	@OneToMany(mappedBy="modules", targetEntity=Lesson.class, fetch = FetchType.LAZY)
	private List<Lesson> lessons;
	
	@OneToMany(mappedBy="modules", targetEntity=Exercise.class, fetch = FetchType.LAZY)
	private List<Exercise> exrcises;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="course_id")
	private Couser couser;
	
	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public List<Exercise> getExrcises() {
		return exrcises;
	}

	public void setExrcises(List<Exercise> exrcises) {
		this.exrcises = exrcises;
	}

	public Couser getCouser() {
		return couser;
	}

	public void setCouser(Couser couser) {
		this.couser = couser;
	}
	
	
}
