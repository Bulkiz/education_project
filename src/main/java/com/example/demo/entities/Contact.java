package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.enums.ContactType;

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
@Table(name = "contacts")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contact_type", columnDefinition = "int2")
	private ContactType contactType;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "r_contacts_contractors", 
	joinColumns = @JoinColumn(name = "contact_id"),
	inverseJoinColumns = @JoinColumn(name = "contractor_id"))
	private Contractor  contractor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "r_contacts_facilities",
	joinColumns = @JoinColumn(name = "contact_id"),
	inverseJoinColumns = @JoinColumn(name = "facility_id"))
	private Facility facility;
}
