package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.CurrencyDTO;
import com.example.demo.entities.Currency;

@Component
public class CurrencyMapper implements ModelMapper<CurrencyDTO, Currency> {
	
	public CurrencyDTO toDto(Currency currency) {
		
		return CurrencyDTO.builder().
				id(currency.getId()).
				name(currency.getName()).
				code(currency.getCode()).
				isActive(currency.getIsActive()).
				build();
	}
	
	public Currency toEntity(CurrencyDTO currencyDTO) {
		
		return Currency.builder().
				id(currencyDTO.getId()).
				name(currencyDTO.getName()).
				code(currencyDTO.getCode()).
				isActive(currencyDTO.getIsActive()).
				build();
	}
	
	public List<CurrencyDTO> allToDtos(List<Currency> currencies) {
		
		return currencies.stream().map(currency -> toDto(currency)).collect(Collectors.toList());
	}
	
	public List<Currency> allToEntities(List<CurrencyDTO> currencyDTOs) {
		
		return currencyDTOs.stream().map(currency -> toEntity(currency)).collect(Collectors.toList());
	}


}
