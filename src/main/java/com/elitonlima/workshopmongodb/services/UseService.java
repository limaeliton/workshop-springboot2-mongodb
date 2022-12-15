package com.elitonlima.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitonlima.workshopmongodb.domain.User;
import com.elitonlima.workshopmongodb.dto.UserDTO;
import com.elitonlima.workshopmongodb.repository.UseRepository;
import com.elitonlima.workshopmongodb.services.exception.ObjectNotFoundException;

@Service // pode ser um serviço que vai ser injeto em outras classes.
public class UseService {
	
	@Autowired // FAZ O SERVIÇO CONVERSAR COM O REPOSITÓRIO.
	private  UseRepository repo;
	
	// retorna todos os usuários
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	// post
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	// retorna um novo usuário
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	

}
