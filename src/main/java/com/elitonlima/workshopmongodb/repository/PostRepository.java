package com.elitonlima.workshopmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.elitonlima.workshopmongodb.domain.Post;

// é uma interface
@Repository // para salvar e fazer operações no banco de dados

public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);


	List<Post> findByTitleContainingIgnoreCase(String text);
}