package com.example.demo.dtos;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContractorDTO {

	private Integer id; 
	@NotNull
	@Size(max = 7)
	private String code; 
	@NotBlank(message = "Name cannot be empty")
	@Size(min = 4, max = 50, message = "Name must be between 4 and 50 characters")
	private String name;
	@NotNull(message = "Contractor active status is missing")
	private Boolean isActive;
	private LocalDateTime registrationTime;
	@NotNull(message = "Correspondence address cannot be empty")
	private AddressDTO correspondenceAddress;
	@NotNull(message = "Contractor type is missing")
	private ContractorType contractorType;
	@NotNull(message = "Legal type is missing")
	private LegalType legalType;
	@Size(min = 10, max = 10, message = "Invalid PIN")
	private String pin;
	@NotNull(message = "Registration address cannot be empty")
	private AddressDTO registrationAddress;
	@Size(min = 9, max = 13, message = "Invalid Bulstat")
	private String uic;
	@Pattern(regexp = "^(ATU[0-9]{8}|BE[01][0-9]{9}|BG[0-9]{9,10}|HR[0-9]{11}|CY[A-Z0-9]{9}|CZ[0-9]{8,10}|DK[0-9]{8}"
			+ "|EE[0-9]{9}|FI[0-9]{8}|FR[0-9A-Z]{2}[0-9]{9}"
			+ "|DE[0-9]{9}|EL[0-9]{9}|HU[0-9]{8}|IE([0-9]{7}[A-Z]{1,2}|[0-9][A-Z][0-9]{5}[A-Z])|IT[0-9]{11}"
			+ "|LV[0-9]{11}|LT([0-9]{9}|[0-9]{12})|LU[0-9]{8}|MT[0-9]{8}|NL[0-9]{9}B[0-9]{2}"
			+ "|PL[0-9]{10}|PT[0-9]{9}|RO[0-9]{2,10}|SK[0-9]{10}|SI[0-9]{8}"
			+ "|ES[A-Z]([0-9]{8}|[0-9]{7}[A-Z])|SE[0-9]{12}|GB([0-9]{9}|[0-9]{12}|GD[0-4][0-9]{2}|HA[5-9][0-9]{2}))$", message = "Invalid VAT")
	private String vat;
	@NotNull(message = "Invoice address cannot be empty")
	private AddressDTO invoiceAddress;
	@Size(min = 4, max = 50, message = "Responsible offical's name must be between 4 and 50 characters")
	private String responsibleOfficial;
	@NotNull(message = "You should provide one or more contacts")
	@Valid
	private List<ContactDTO> contacts;
	@NotNull(message = "You should provide one or more facilities")
	@Valid
	private List<FacilityDTO> facilities;
	@NotNull(message = "You should provide one or more bank accounts")
	@Valid
	private List<BankAccountDTO> bankAccounts;
	

	
}
