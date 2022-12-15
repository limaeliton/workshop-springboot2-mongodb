package com.elitonlima.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.elitonlima.workshopmongodb.domain.User;
// é uma interface
@Repository // para salvar e fazer operações no banco de dados
public interface UseRepository extends MongoRepository<User, String>{
	
	

}
