package com.elitonlima.workshopmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitonlima.workshopmongodb.domain.User;
import com.elitonlima.workshopmongodb.dto.UserDTO;
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
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = service.findAll();
		// converte de list para listDTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x))
		.collect(Collectors.toList());
				return ResponseEntity.ok().body(listDto);
	}
	
	// metodo para retorna o usuário por ID
		@GetMapping(value="/{id}")
		// ResponseEntity<List<User>> = Objeto sofisticado do spring, emcapsula resposta HTTP
		public ResponseEntity<UserDTO> findById(@PathVariable String id){
			User obj = service.findById(id);
			return ResponseEntity.ok().body(new UserDTO(obj));
		}
	

}
