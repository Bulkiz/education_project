package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.FacilityDTO;
import com.example.demo.entities.Facility;

@Component
public class FacilityMapper {
	
	@Autowired private AddressMapper addressMapper;
	
	@Autowired
	ContactMapper contactMapper;

	public FacilityDTO toDto(Facility facility) {
		
		FacilityDTO facilityDTO = new FacilityDTO();
		facilityDTO.setId(facility.getId());
		facilityDTO.setCode(facility.getCode());
		facilityDTO.setName(facility.getName());
		facilityDTO.setIsActive(facility.getIsActive());
		facilityDTO.setFacilityAddress(addressMapper.toDto(facility.getFacilityAddress()));
		facilityDTO.setContacts(contactMapper.allToDtos(facility.getContacts()));
		
		return facilityDTO;
	}
	
	public Facility toEntity(FacilityDTO facilityDTO) {
		
		Facility facility = new Facility();
		facility.setId(facilityDTO.getId());
		facility.setCode(facilityDTO.getCode());
		facility.setName(facilityDTO.getName());
		facility.setIsActive(facilityDTO.getIsActive());
		facility.setFacilityAddress(addressMapper.toEntity(facilityDTO.getFacilityAddress()));
		facility.setContacts(contactMapper.allToEntity(facilityDTO.getContacts()));
		
		return facility;
	}
	
	public List<FacilityDTO> allToDtos(List<Facility> facilities) {
		
		return facilities.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}
	
	public List<Facility> allToEntities(List<FacilityDTO> facilityDTOs) {
		
		return facilityDTOs.stream().map(x -> toEntity(x)).collect(Collectors.toList());
	}
	
	
	
	
	
	
	

}
