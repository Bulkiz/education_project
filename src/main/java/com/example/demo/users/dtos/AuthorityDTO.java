package com.example.demo.users.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthorityDTO {
	
	private Integer id;
	private String name;
	private String type;
	private String description;
	private List<AuthorityDTO> inheritedAuthorityDTOs;
}
