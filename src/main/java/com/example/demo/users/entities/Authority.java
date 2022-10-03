package com.example.demo.users.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "authorities")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "r_users_authorities", 
	joinColumns = @JoinColumn(name = "authority_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "r_authorities_authorities",
	joinColumns = @JoinColumn(name =  "parent"),
	inverseJoinColumns = @JoinColumn(name = "child"))
	private List<Authority> inheritedAuthorities;
}
