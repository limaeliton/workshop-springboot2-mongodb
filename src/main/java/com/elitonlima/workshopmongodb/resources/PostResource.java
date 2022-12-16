package com.elitonlima.workshopmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elitonlima.workshopmongodb.domain.Post;
import com.elitonlima.workshopmongodb.services.PostService;

// resources = requisições na web

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired // FAZ O SERVIÇO CONVERSAR COM O RESOURCE.
	private PostService service;

	// metodo para retorna o usuário por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// ResponseEntity<List<User>> = Objeto sofisticado do spring, emcapsula resposta
	// HTTP
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}