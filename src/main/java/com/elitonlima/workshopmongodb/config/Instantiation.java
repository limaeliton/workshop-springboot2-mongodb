package com.elitonlima.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.elitonlima.workshopmongodb.domain.Post;
import com.elitonlima.workshopmongodb.domain.User;
import com.elitonlima.workshopmongodb.dto.AuthorDTO;
import com.elitonlima.workshopmongodb.repository.PostRepository;
import com.elitonlima.workshopmongodb.repository.UseRepository;

@Configuration // O SPRING ENTENDE QUE É UMA CONFIGURAÇÃO.
public class Instantiation implements CommandLineRunner {

	@Autowired // FAZ o PACOTE CONFIG. CONVERSAR COM O REPOSITÓRIO.
	private UseRepository userRepository;
	
	@Autowired // FAZ o PACOTE CONFIG. CONVERSAR COM O REPOSITÓRIO.
	private PostRepository postRepository;

	@Override
	// instacia os objetos e salva no banco de dados, esse metodo
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		// primeiro salva os usuários
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("15/12/2022"), "Viajar", "Vou viajar para Foz. Partil!",new AuthorDTO( maria));
		Post post2 = new Post(null, sdf.parse("16/12/2022"), "Boa noite", "Vou dormi agora", new AuthorDTO( maria));
		
		// e depois faz a cópia para o AutoDTO
		postRepository.saveAll(Arrays.asList(post1,post2));

	}

}
