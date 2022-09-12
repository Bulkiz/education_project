package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.AddressDTO;
import com.example.demo.entities.Address;

@Component
public class AddressMapper implements ModelMapper<AddressDTO, Address>{
	
	@Autowired private CountryMapper countryMapper;
	
	public AddressDTO toDto(Address address) {
		
		return AddressDTO.builder().
				id(address.getId()).
				country(countryMapper.toDto(address.getCountry())).
				addressType(address.getAddressType()).
				city(address.getCity()).
				postCode(address.getPostCode()).
				streetAddress(address.getStreetAddress()).
				build();
	
	}
	
	public Address toEntity(AddressDTO addressDTO) {
		
		return Address.builder().
				id(addressDTO.getId()).
				country(countryMapper.toEntity(addressDTO.getCountry())).
				addressType(addressDTO.getAddressType()).
				city(addressDTO.getCity()).
				postCode(addressDTO.getPostCode()).
				streetAddress(addressDTO.getStreetAddress()).
				build();
	}

	public List<AddressDTO> allToDtos(List<Address> addresses) {
		
		return addresses.stream().map(address -> toDto(address)).collect(Collectors.toList());
	}

	public List<Address> allToEntities(List<AddressDTO> addressDTOs) {
		
		return addressDTOs.stream().map(address -> toEntity(address)).collect(Collectors.toList());
	}
}
