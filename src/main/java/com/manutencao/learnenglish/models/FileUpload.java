package com.manutencao.learnenglish.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

@Entity
@Table(name="files")
public class FileUpload implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nameFile;
	@Column
	private String urlFile;
	@Column
	private String fileType;
	@JsonIgnore
	@Lob
	private byte[] data;
	
	
	public FileUpload() {
		super();
	}
		

	public FileUpload(String nameFile, String urlFile, String fileType, byte[] data) {
		super();
		this.nameFile = nameFile;
		this.urlFile = urlFile;
		this.fileType = fileType;
		this.data = data;
	}

	

	public FileUpload(String nameFile, String urlFile, String fileType) {
		super();
		this.nameFile = nameFile;
		this.urlFile = urlFile;
		this.fileType = fileType;
	}


	public String getNameFile() {
		return nameFile;
	}
	
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	
	public String getUrlFile() {
		return urlFile;
	}
	
	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
}
