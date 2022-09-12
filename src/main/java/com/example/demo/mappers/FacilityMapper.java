package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.FacilityDTO;
import com.example.demo.entities.Facility;

@Component
public class FacilityMapper implements ModelMapper<FacilityDTO,	Facility> {
	
	@Autowired private AddressMapper addressMapper;
	
	@Autowired private ContactMapper contactMapper;

	public FacilityDTO toDto(Facility facility) {
		
		return FacilityDTO.builder().
				id(facility.getId()).
				code(facility.getCode()).
				name(facility.getName()).
				isActive(facility.getIsActive()).
				facilityAddress(addressMapper.toDto(facility.getFacilityAddress())).
				contacts(contactMapper.allToDtos(facility.getContacts())).
				build();
	}
	
	public Facility toEntity(FacilityDTO facilityDTO) {

		return Facility.builder().
				id(facilityDTO.getId()).
				code(facilityDTO.getCode()).
				name(facilityDTO.getName()).
				isActive(facilityDTO.getIsActive()).
				facilityAddress(addressMapper.toEntity(facilityDTO.getFacilityAddress())).
				contacts(contactMapper.allToEntities(facilityDTO.getContacts())).
				build();
	}
	
	public List<FacilityDTO> allToDtos(List<Facility> facilities) {
		
		return facilities.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}
	
	public List<Facility> allToEntities(List<FacilityDTO> facilityDTOs) {
		
		return facilityDTOs.stream().map(x -> toEntity(x)).collect(Collectors.toList());
	}

}
