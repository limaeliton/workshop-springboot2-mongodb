package com.elitonlima.workshopmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elitonlima.workshopmongodb.domain.User;
import com.elitonlima.workshopmongodb.dto.UserDTO;
import com.elitonlima.workshopmongodb.services.UseService;

// resources = requisições na web

@RestController
@RequestMapping(value = "/users")
public class UseResource {

	@Autowired // FAZ O SERVIÇO CONVERSAR COM O RESOURCE.
	private UseService service;

	// metodo para retorna lista de usuário
    // ResponseEntity<List<User>> = Objeto sofisticado do spring, emcapsula resposta
	// HTTP
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();
		// converte de list para listDTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// metodo para retorna o usuário por ID
	@RequestMapping(value = "/{id}" ,method=RequestMethod.GET)
	// ResponseEntity<List<User>> = Objeto sofisticado do spring, emcapsula resposta
	// HTTP
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	
	// metodo para inserir um  o usuário
	// ResponseEntity<List<User>> = Objeto sofisticado do spring, emcapsula resposta
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto); // recebe o objeto
		obj = service.insert(obj); // inseri o objeto no banco
		
		// CRIA UM CABEÇALHO COM UM URL DO NOVO RECURSO CRIADO
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		// retorna uma resposta vazia com o cod 201.
		return ResponseEntity.created(uri).build();
	}
	
	
	// metodo para deletar por  ID
		@RequestMapping(value = "/{id}" ,method=RequestMethod.DELETE)
		// ResponseEntity<List<User>> = Objeto sofisticado do spring, emcapsula resposta
		// HTTP
		public ResponseEntity<Void> delete(@PathVariable String id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
	

}
