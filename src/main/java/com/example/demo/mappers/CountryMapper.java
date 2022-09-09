package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.CountryDTO;
import com.example.demo.entities.Country;

@Component
public class CountryMapper {
	
	public CountryDTO toDto(Country country) {
		
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(country.getId());
		countryDTO.setName(country.getName());
		countryDTO.setIsActive(country.getIsActive());
		
		return countryDTO;
	}
	
	public Country toEntity(CountryDTO countryDTO) {
		
		 Country country = new Country();
		 country.setId(countryDTO.getId());
		 country.setName(countryDTO.getName());
		 country.setIsActive(countryDTO.getIsActive());
		 
		 return country;
	}
	
	public List<CountryDTO> allToDto(List<Country> countries) {
		
		return countries.stream().map(country -> toDto(country)).collect(Collectors.toList());
	}
	
	public List<Country> allToEntity(List<CountryDTO> countryDTOs) {
		
		return countryDTOs.stream().map(country -> toEntity(country)).collect(Collectors.toList());
	}
}
