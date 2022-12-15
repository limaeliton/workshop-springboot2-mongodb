package com.elitonlima.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitonlima.workshopmongodb.domain.User;
import com.elitonlima.workshopmongodb.repository.UseRepository;

@Service // pode ser um serviço que vai ser injeto em outras classes.
public class UseService {
	
	@Autowired // FAZ O SERVIÇO CONVERSAR COM O REPOSITÓRIO.
	private  UseRepository repo;
	
	// retorna todos os usuários
	public List<User> findAll(){
		return repo.findAll();
	}

}
