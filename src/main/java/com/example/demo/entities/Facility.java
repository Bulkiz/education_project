package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "facilities")
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_address_id", referencedColumnName = "id")
	private Address facilityAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractor_id", referencedColumnName = "id")
	private Contractor contractor;
	
	@OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
	private List<Contact> contacts;
}
