package com.org.backendjava.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionDetails> handleRuntimeException(Exception e, HttpServletRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), 400, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(400).body(exceptionDetails);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleNotFoundException(Exception e, HttpServletRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), 400, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(404).body(exceptionDetails);
	}
}