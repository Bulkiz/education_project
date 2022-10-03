package com.example.demo.users.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mappers.ModelMapper;
import com.example.demo.users.dtos.UserDTO;
import com.example.demo.users.entities.User;

@Component
public class UserMapper implements ModelMapper<UserDTO, User>{
	
	@Autowired private AuthorityMapper authorityMapper;
	
	public User toEntityRegister(UserDTO userDTO) {
		return User.builder().
				id(userDTO.getId()).
				username(userDTO.getUsername()).
				password(userDTO.getPassword()).
				email(userDTO.getEmail()).
				build();
	}
	
	@Override
	public UserDTO toDto(User user) {
		return UserDTO.builder().
				id(user.getId()).
				username(user.getUsername()).
				password(user.getPassword()).
				isActive(user.getIsActive()).
				email(user.getEmail()).
				authorities(authorityMapper.allToDtos(user.getAuthorities())).
				build();
	}

	@Override
	public User toEntity(UserDTO userDTO) {
		return User.builder().
				id(userDTO.getId()).
				username(userDTO.getUsername()).
				password(userDTO.getPassword()).
				isActive(userDTO.getIsActive()).
				email(userDTO.getEmail()).
				authorities(authorityMapper.allToEntities(userDTO.getAuthorities())).
				build();
	}

	@Override
	public List<UserDTO> allToDtos(List<User> users) {
		return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
	}

	@Override
	public List<User> allToEntities(List<UserDTO> userDTOs) {
		return userDTOs.stream().map(user -> toEntity(user)).collect(Collectors.toList());
	}
	
	
}
