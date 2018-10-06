package com.manutencao.learnenglish.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

@Entity
@Table(name="cousers")
public class Couser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String title;
	
	@Column
	private int workload;
	
	@OneToMany(mappedBy="couser", targetEntity=Module.class, fetch = FetchType.LAZY)
	private List<Module> modules;
	
	@OneToMany( targetEntity=User.class, fetch = FetchType.LAZY)
	private List<User> students;
	
	@OneToMany( targetEntity=User.class, fetch = FetchType.LAZY)
	private List<User> instructor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public List<User> getInstructor() {
		return instructor;
	}

	public void setInstructor(List<User> instructor) {
		this.instructor = instructor;
	}

	
}
