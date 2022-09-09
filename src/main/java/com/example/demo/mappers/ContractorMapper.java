package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.entities.Contractor;


@Component
public class ContractorMapper {
	
	@Autowired private AddressMapper addressMapper;
	
	@Autowired private BankAccountMapper bankAccountMapper;
	
	@Autowired private ContactMapper contactMapper;
	
	@Autowired private FacilityMapper facilityMapper;
	
	public ContractorDTO toDto(Contractor contractor) {
		
		ContractorDTO contractorDTO = new ContractorDTO();
		contractorDTO.setId(contractor.getId());
		contractorDTO.setCode(contractor.getCode());
		contractorDTO.setName(contractor.getName());
		contractorDTO.setIsActive(contractor.getIsActive());
		contractorDTO.setRegistrationTime(contractor.getRegistrationTime());
		contractorDTO.setCorrespondenceAddress(addressMapper.toDto(contractor.getCorrespondenceAddress()));
		contractorDTO.setContractorType(contractor.getContractorType());
		contractorDTO.setLegalType(contractor.getLegalType());
		contractorDTO.setPin(contractor.getPin());
		contractorDTO.setRegistrationAddress(addressMapper.toDto(contractor.getRegistrationAddress()));
		contractorDTO.setUic(contractor.getUic());
		contractorDTO.setVat(contractor.getVat());
		contractorDTO.setInvoiceAddress(addressMapper.toDto(contractor.getInvoiceAddress()));
		contractorDTO.setResponsibleOfficial(contractor.getResponsibleOfficial());
		contractorDTO.setContacts(contactMapper.allToDtos(contractor.getContacts()));
		contractorDTO.setBankAccounts(bankAccountMapper.allToDtos(contractor.getBankAccounts()));
		contractorDTO.setFacilities(facilityMapper.allToDtos(contractor.getFacilities()));
	
		
		return contractorDTO;
	}
	
	public Contractor toEntity(ContractorDTO contractorDto) {
		Contractor contractor = new Contractor();
		
		contractor.setId(contractorDto.getId());
		contractor.setCode(contractorDto.getCode());
		contractor.setName(contractorDto.getName());
		contractor.setIsActive(contractorDto.getIsActive());
		contractor.setRegistrationTime(contractorDto.getRegistrationTime());
		contractor.setCorrespondenceAddress(addressMapper.toEntity(contractorDto.getCorrespondenceAddress()));
		contractor.setContractorType(contractorDto.getContractorType());
		contractor.setLegalType(contractorDto.getLegalType());
		contractor.setPin(contractorDto.getPin());
		contractor.setRegistrationAddress(addressMapper.toEntity(contractorDto.getRegistrationAddress()));
		contractor.setUic(contractorDto.getUic());
		contractor.setVat(contractorDto.getVat());
		contractor.setInvoiceAddress(addressMapper.toEntity(contractorDto.getInvoiceAddress()));
		contractor.setResponsibleOfficial(contractorDto.getResponsibleOfficial());
		contractor.setContacts(contactMapper.allToEntity(contractorDto.getContacts()));
		contractor.setBankAccounts(bankAccountMapper.allToEntity(contractorDto.getBankAccounts()));
		contractor.setFacilities(facilityMapper.allToEntities(contractorDto.getFacilities()));
		return contractor; 
	}
	
	public List<ContractorDTO> allToDtos(List<Contractor> contractors) {
		
		return contractors.stream().map(x -> (toDto(x))).collect(Collectors.toList());
	}
	
	public List<Contractor> allToEntities(List<ContractorDTO> contractorDtos) {
		
		return contractorDtos.stream().map(x -> (toEntity(x))).collect(Collectors.toList());
	}
	

}
