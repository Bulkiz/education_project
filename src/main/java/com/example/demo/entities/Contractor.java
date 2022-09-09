package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contractors")
public class Contractor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "registration_time")
	private LocalDateTime registrationTime;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "correspondence_address_id", referencedColumnName = "id")
	private Address correspondenceAddress;
	
	@Column(name = "contractor_type", columnDefinition = "int2")
	private ContractorType contractorType;
	
	@Column(name = "legal_type", columnDefinition = "int2")
	private LegalType legalType;
	
	@Column(name = "pin")
	private String pin;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "registration_address_id", referencedColumnName = "id")
	private Address registrationAddress;
	
	@Column(name = "uic")
	private String uic;
	
	@Column(name = "vat")
	private String vat;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_address_id", referencedColumnName = "id")
	private Address invoiceAddress;;
	
	@Column(name = "responsible_official")
	private String responsibleOfficial;
	
	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY)
	private List<Contact> contacts;
	
	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY)
	private List<Facility> facilities;
	
	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY)
	private List<BankAccount> bankAccounts;

	
}
