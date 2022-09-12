package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "bank_accounts")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "swift")
	private String swift;
	
	@Column(name = "iban")
	private String iban;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id")
	private Currency currency;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractor_id")
	private Contractor contractor;
	
}
