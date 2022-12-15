package com.elitonlima.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.elitonlima.workshopmongodb.domain.User;
import com.elitonlima.workshopmongodb.repository.UseRepository;

@Configuration // O SPRING ENTENDE QUE É UMA CONFIGURAÇÃO.
public class Instantiation implements CommandLineRunner{

	@Autowired // FAZ o PACOTE CONFIG. CONVERSAR COM O REPOSITÓRIO.
	private UseRepository userRepository;
	
	@Override
	// instacia os objetos e salva no banco de dados, esse metodo
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
