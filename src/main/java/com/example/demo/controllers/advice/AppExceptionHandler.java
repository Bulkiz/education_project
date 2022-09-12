package com.example.demo.controllers.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidException(MethodArgumentNotValidException exception) {
		Map<String, String> exceptionMapper = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			exceptionMapper.put(error.getField(), error.getDefaultMessage());
		});
		
		return exceptionMapper;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String handle() {
		return "Unknown error ocurred";
	}
	
	
}
