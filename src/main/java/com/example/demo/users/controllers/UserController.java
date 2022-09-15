package com.example.demo.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.dtos.UserDTO;
import com.example.demo.users.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	@ResponseStatus(value = HttpStatus.CREATED)
	public String registerUser(@RequestBody UserDTO userDTO) {
		
		userService.register(userDTO);
		
		return "User " + userDTO.getUserName() + "successfully created";
	}

}
