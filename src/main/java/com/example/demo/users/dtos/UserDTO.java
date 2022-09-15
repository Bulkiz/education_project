package com.example.demo.users.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
	
	private int id;
	private String userName;
	private String password;
	private Boolean isActive;
	private List<RoleDTO> roles;
}
