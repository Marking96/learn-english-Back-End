package com.manutencao.learnenglish.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

@Entity
@Table(name="lessons")
public class Lesson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String videoToUrl;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoToUrl() {
		return videoToUrl;
	}

	public void setVideoToUrl(String videoToUrl) {
		this.videoToUrl = videoToUrl;
	}
	
	
	
	
}
