package com.example.demo.users.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.users.dtos.UserDTO;
import com.example.demo.users.entities.Role;
import com.example.demo.users.entities.User;
import com.example.demo.users.mappers.RoleMapper;
import com.example.demo.users.mappers.UserMapper;
import com.example.demo.users.repositories.RoleRepository;
import com.example.demo.users.repositories.UserRepository;
import com.example.demo.users.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Transactional
	public void register(UserDTO userDTO) {
		User user = userMapper.toEntity(userDTO);
		userRepository.save(user);
		List<Role> roles = roleMapper.allToEntities(userDTO.getRoles());
		roles.forEach(role -> role.setUser(user));
		roleRepository.saveAll(roles);
	
	}
	
}
