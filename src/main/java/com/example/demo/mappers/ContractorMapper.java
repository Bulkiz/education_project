package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.entities.Contractor;


@Component
public class ContractorMapper implements ModelMapper<ContractorDTO, Contractor> {
	
	private AddressMapper addressMapper;
	
	private BankAccountMapper bankAccountMapper;
	
	private ContactMapper contactMapper;
	
	private FacilityMapper facilityMapper;
	
	@Autowired
	public ContractorMapper(AddressMapper addressMapper, BankAccountMapper bankAccountMapper, 
			ContactMapper contactMapper, FacilityMapper facilityMapper) {
		this.facilityMapper = facilityMapper;
		this.addressMapper = addressMapper;
		this.bankAccountMapper = bankAccountMapper;
		this.contactMapper = contactMapper;
	}
	
	public ContractorDTO toDtoBasicInfo(Contractor contractor) {

		return ContractorDTO.builder().
				id(contractor.getId()).
				code(contractor.getCode()).
				name(contractor.getName()).
				isActive(contractor.getIsActive()).
				contractorType(contractor.getContractorType()).
				legalType(contractor.getLegalType()).
				pin(contractor.getPin()).
				build();
	}
	
	public ContractorDTO toDto(Contractor contractor) {

		return ContractorDTO.builder().
				id(contractor.getId()).
				code(contractor.getCode()).
				name(contractor.getName()).
				isActive(contractor.getIsActive()).
				registrationTime(contractor.getRegistrationTime()).
				correspondenceAddress(addressMapper.toDto(contractor.getCorrespondenceAddress())).
				contractorType(contractor.getContractorType()).
				legalType(contractor.getLegalType()).
				pin(contractor.getPin()).
				registrationAddress(addressMapper.toDto(contractor.getRegistrationAddress())).
				uic(contractor.getUic()).
				vat(contractor.getVat()).
				invoiceAddress(addressMapper.toDto(contractor.getInvoiceAddress())).
				responsibleOfficial(contractor.getResponsibleOfficial()).
				contacts(contactMapper.allToDtos(contractor.getContacts())).
				bankAccounts(bankAccountMapper.allToDtos(contractor.getBankAccounts())).
				facilities(facilityMapper.allToDtos(contractor.getFacilities())).
				build();
	}
	
	public Contractor toEntity(ContractorDTO contractorDto) {

		return Contractor.builder().
				id(contractorDto.getId()).
				code(contractorDto.getCode()).
				name(contractorDto.getName()).
				isActive(contractorDto.getIsActive()).
				registrationTime(contractorDto.getRegistrationTime()).
				correspondenceAddress(addressMapper.toEntity(contractorDto.getCorrespondenceAddress())).
				contractorType(contractorDto.getContractorType()).
				legalType(contractorDto.getLegalType()).
				pin(contractorDto.getPin()).
				registrationAddress(addressMapper.toEntity(contractorDto.getRegistrationAddress())).
				uic(contractorDto.getUic()).
				vat(contractorDto.getVat()).
				invoiceAddress(addressMapper.toEntity(contractorDto.getInvoiceAddress())).
				responsibleOfficial(contractorDto.getResponsibleOfficial()).
				contacts(contactMapper.allToEntities(contractorDto.getContacts())).
				bankAccounts(bankAccountMapper.allToEntities(contractorDto.getBankAccounts())).
				facilities(facilityMapper.allToEntities(contractorDto.getFacilities())).
				build(); 
	}
	
	public List<ContractorDTO> allToDtos(List<Contractor> contractors) {
		
		return contractors.stream().map(x -> (toDto(x))).collect(Collectors.toList());
	}
	
	public List<Contractor> allToEntities(List<ContractorDTO> contractorDtos) {
		
		return contractorDtos.stream().map(x -> (toEntity(x))).collect(Collectors.toList());
	}

	
	

}
