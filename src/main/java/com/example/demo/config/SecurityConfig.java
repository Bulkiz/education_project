package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig	{
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/register", "/").permitAll().
		and().authorizeRequests().antMatchers(HttpMethod.GET, "/contractors").hasAuthority("GET_ALL").
		and().authorizeRequests().antMatchers(HttpMethod.POST, "/contractors").hasAnyAuthority("POST").
		and().authorizeRequests().antMatchers(HttpMethod.PUT, "/contractors").hasAuthority("PUT").and().httpBasic();
		http.csrf().disable();
		return http.build();
	}
		
	@Bean
	AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService)
		  throws Exception {
		    return http.getSharedObject(AuthenticationManagerBuilder.class)
		      .userDetailsService(userDetailService)
		      .passwordEncoder(bCryptPasswordEncoder)
		      .and()
		      .build();
	}


	
	


	
		

}
