package com.example.demo.users.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.mappers.ModelMapper;
import com.example.demo.users.dtos.RoleDTO;
import com.example.demo.users.entities.Role;

@Component
public class RoleMapper implements ModelMapper<RoleDTO, Role>{

	public RoleDTO toDto(Role role) {

		return RoleDTO.builder().
				id(role.getId()).
				name(role.getName()).
				build();
	}

	public Role toEntity(RoleDTO roleDTO) {
		
		return Role.builder().
				id(roleDTO.getId()).
				name(roleDTO.getName()).
				build();
		
	}

	public List<RoleDTO> allToDtos(List<Role> roles) {
		
		return roles.stream().map(role -> toDto(role)).collect(Collectors.toList());
	}

	public List<Role> allToEntities(List<RoleDTO> roleDTOs) {
		
		return roleDTOs.stream().map(roleDTO -> toEntity(roleDTO)).collect(Collectors.toList());
	}

}
