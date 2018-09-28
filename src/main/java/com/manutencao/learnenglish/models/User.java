package com.manutencao.learnenglish.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String username;
	
	@Column
	private String password;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="type")
	private Set<Integer> type = new HashSet<>();

	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		addType(UserType.STUDENTY);
	}
	
	public User() {
		addType(UserType.STUDENTY);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserType> getType(){
		return type.stream().map(x -> UserType.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addType(UserType usertype) {
		type.add(usertype.getCod());
	}
	
}
