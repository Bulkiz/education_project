package com.example.demo.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.users.entities.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	
}
