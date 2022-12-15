package com.elitonlima.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitonlima.workshopmongodb.domain.User;
import com.elitonlima.workshopmongodb.services.UseService;

// resources = requisições na web

@RestController
@RequestMapping(value = "/users")
public class UseResource {
	
	@Autowired // FAZ O SERVIÇO CONVERSAR COM  O RESOURCE.
	private UseService service;
	
	// metodo para retorna lista de usuário
	@GetMapping
	// ResponseEntity<List<User>> = Objeto sofisticado do spring, emcapsula resposta HTTP
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
