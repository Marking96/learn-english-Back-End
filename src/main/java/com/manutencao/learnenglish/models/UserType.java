package com.manutencao.learnenglish.models;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

public enum UserType {
	
	ADMIN(1, "ROLE_ADMIN"),
	INSTRUCTOR(2, "ROLE_INSTRUCTOR"),
	STUDENTY(3, "ROLE_STUDENTY");
	
	private int cod;
	private String descricao;
	
	private UserType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static UserType toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (UserType x: UserType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido: "+ cod);
	}
	

}
