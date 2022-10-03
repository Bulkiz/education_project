package com.example.demo.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.dtos.UserDTO;
import com.example.demo.users.services.CustomUserDetailsService;

@RestController
public class UserController {
	
	@Autowired private CustomUserDetailsService customUserDetailsService;

	@PostMapping("/user/register")
	public String registerUser(@RequestBody UserDTO userDTO) {
		customUserDetailsService.registerUser(userDTO);
		return "User " + userDTO.getUsername() + " successfully created";
	}
	
	
	
}
