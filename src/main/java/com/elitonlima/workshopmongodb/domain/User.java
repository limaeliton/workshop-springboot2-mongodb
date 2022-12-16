package com.elitonlima.workshopmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user") // informa que é do Mongo
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // chave primária
	private String id;
	private String name;
	private String email;

	// LISTA É UMA INTERFACE E O ARRAYSLIST É UMA IMPLEMENTAÇÃO POSSÍVEL DESSA LISTA.
	// lista de post é uma coleção.
	// (lazy = true) garante que os posto so serão carregados se forem acessados.
	@DBRef(lazy = true) // reconhece que é uma referência 
	private List<Post> posts = new ArrayList<>();
	
	public User() {
	}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPots(List<Post> pots) {
		this.posts = pots;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	
}
