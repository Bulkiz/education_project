package com.example.demo.users.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDTO {
	
	private Integer id;
	private String username;
	private String password;
	private Boolean isActive;
	private String email;
	private List<AuthorityDTO> authorities;
}
