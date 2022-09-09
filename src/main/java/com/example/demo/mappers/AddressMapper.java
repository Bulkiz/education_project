package com.example.demo.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.AddressDTO;
import com.example.demo.entities.Address;

@Component
public class AddressMapper {
	
	@Autowired private CountryMapper countryMapper;
	
	public AddressDTO toDto(Address address) {
		
		AddressDTO addressDTO = new AddressDTO();
		
		addressDTO.setId(address.getId());
		addressDTO.setCountry(countryMapper.toDto(address.getCountry()));
		addressDTO.setAddressType(address.getAddressType());
		addressDTO.setCity(address.getCity());
		addressDTO.setPostCode(address.getPostCode());
		addressDTO.setStreetAddress(address.getStreetAddress());
		
		return addressDTO;
	
	}
	
	public Address toEntity(AddressDTO addressDTO) {
		
		Address address = new Address();
		address.setId(addressDTO.getId());
		address.setCountry(countryMapper.toEntity(addressDTO.getCountry()));
		address.setAddressType(addressDTO.getAddressType());
		address.setCity(addressDTO.getCity());
		address.setPostCode(addressDTO.getPostCode());
		address.setStreetAddress(addressDTO.getStreetAddress());
		
		return address;
	}
}
