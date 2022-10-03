package com.example.demo.users.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.users.dtos.UserDTO;
import com.example.demo.users.entities.Authority;
import com.example.demo.users.entities.User;
import com.example.demo.users.mappers.UserMapper;
import com.example.demo.users.repositories.AuthorityRepository;
import com.example.demo.users.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired private UserRepository userRepository;
	@Autowired private AuthorityRepository authorityRepository;
	@Autowired private UserMapper userMapper;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
			UserDTO user = userMapper.toDto(userRepository.findByUsername(username).
					orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username)));
			return new CustomUserDetails(user);
		
	}
	
	@Transactional
	public void registerUser(UserDTO userDTO) {
		User user = userMapper.toEntityRegister(userDTO);
		user.setAuthorities(Arrays.asList(userAuthority()));
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.getAuthorities().forEach(authority -> authority.setUser(user));
		authorityRepository.saveAll(user.getAuthorities());
		user.setIsActive(true);
		userRepository.save(user);
	}
	
	private Authority userAuthority() {
	return	Authority.builder().
			name("USER").type("USER").description("USER").build();
	}

}
