package com.elitonlima.workshopmongodb.dto;

import java.io.Serializable;
import java.util.Objects;

import com.elitonlima.workshopmongodb.domain.User;

// DTO NÃO PRECISA DO hashCode() ,equals POIS NÃO VAI COMPARAR NADA SÓ PEGAR O NOME E ID.

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO() {
	}

	// vai copiar o nome e o ID do usuário para o Objeto DTO
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
