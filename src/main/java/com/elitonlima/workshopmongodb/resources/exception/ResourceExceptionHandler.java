package com.elitonlima.workshopmongodb.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.elitonlima.workshopmongodb.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //responsável por tratar possíveis erros nas requisições
public class ResourceExceptionHandler {

	// e padrão do framwork @ExceptionHandler, no tratamento de exceção.
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StanderError>objectNotFound(ObjectNotFoundException e,HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderError err = new StanderError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
