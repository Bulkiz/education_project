package com.example.demo.users.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.mappers.ModelMapper;
import com.example.demo.users.dtos.AuthorityDTO;
import com.example.demo.users.entities.Authority;

@Component
public class AuthorityMapper implements ModelMapper<AuthorityDTO, Authority>{

	@Override
	public AuthorityDTO toDto(Authority authority) {
		return AuthorityDTO.builder().
				id(authority.getId()).
				name(authority.getName()).
				type(authority.getType()).
				description(authority.getDescription()).
				inheritedAuthorityDTOs(allToDtos(authority.getInheritedAuthorities())).
				build();
	}

	@Override
	public Authority toEntity(AuthorityDTO authorityDTO) {
		return Authority.builder().
				id(authorityDTO.getId()).
				name(authorityDTO.getName()).
				type(authorityDTO.getType()).
				description(authorityDTO.getDescription()).
				inheritedAuthorities(allToEntities(authorityDTO.getInheritedAuthorityDTOs())).
				build();
	}

	@Override
	public List<AuthorityDTO> allToDtos(List<Authority> authorities) {	
		return authorities.stream().map(authority -> toDto(authority)).collect(Collectors.toList());
	}

	@Override
	public List<Authority> allToEntities(List<AuthorityDTO> authorityDTOs) {
		return authorityDTOs.stream().map(authority -> toEntity(authority)).collect(Collectors.toList());
	}

}
