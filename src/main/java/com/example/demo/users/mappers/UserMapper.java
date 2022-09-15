package com.example.demo.users.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mappers.ModelMapper;
import com.example.demo.users.dtos.UserDTO;
import com.example.demo.users.entities.User;

@Component
public class UserMapper implements ModelMapper<UserDTO, User>{
	
	@Autowired private RoleMapper roleMapper;
	
	@Override
	public UserDTO toDto(User user) {
		return UserDTO.builder().
				id(user.getId()).
				userName(user.getUserName()).
				password(user.getPassword()).
				isActive(user.getIsActive()).
				roles(roleMapper.allToDtos(user.getRoles())).
				build();
	}

	@Override
	public User toEntity(UserDTO userDTO) {
		return User.builder().
				id(userDTO.getId()).
				userName(userDTO.getUserName()).
				password(userDTO.getPassword()).
				isActive(userDTO.getIsActive()).
				roles(roleMapper.allToEntities(userDTO.getRoles())).
				build();
	}

	@Override
	public List<UserDTO> allToDtos(List<User> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> allToEntities(List<UserDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
