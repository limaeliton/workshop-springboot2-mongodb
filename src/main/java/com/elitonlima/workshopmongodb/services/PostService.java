package com.elitonlima.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitonlima.workshopmongodb.domain.Post;
import com.elitonlima.workshopmongodb.repository.PostRepository;
import com.elitonlima.workshopmongodb.services.exception.ObjectNotFoundException;

@Service // pode ser um serviço que vai ser injeto em outras classes.
public class PostService {

	@Autowired // FAZ O SERVIÇO CONVERSAR COM O REPOSITÓRIO.
	private PostRepository repo;


	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	// Consulta simples com query methods Para Mongo
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}