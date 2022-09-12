package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.CountryDTO;
import com.example.demo.entities.Country;

@Component
public class CountryMapper implements ModelMapper<CountryDTO, Country>{
	
	public CountryDTO toDto(Country country) {

		return CountryDTO.builder().
				id(country.getId()).
				name(country.getName()).
				isActive(country.getIsActive()).
				build();
	}
	
	public Country toEntity(CountryDTO countryDTO) {
	
		 return Country.builder().
				 id(countryDTO.getId()).
				 name(countryDTO.getName()).
				 isActive(countryDTO.getIsActive()).
				 build();
	}
	
	public List<CountryDTO> allToDtos(List<Country> countries) {
		
		return countries.stream().map(country -> toDto(country)).collect(Collectors.toList());
	}
	
	public List<Country> allToEntities(List<CountryDTO> countryDTOs) {
		
		return countryDTOs.stream().map(country -> toEntity(country)).collect(Collectors.toList());
	}
}
