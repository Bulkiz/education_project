package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.CurrencyDTO;
import com.example.demo.entities.Currency;

@Component
public class CurrencyMapper {
	
	public CurrencyDTO toDto(Currency currency) {
		
		CurrencyDTO currencyDTO = new CurrencyDTO();
		currencyDTO.setId(currency.getId());
		currencyDTO.setName(currency.getName());
		currencyDTO.setCode(currency.getCode());
		currencyDTO.setIsActive(currency.getIsActive());
		
		return currencyDTO;
	}
	
	public Currency toEntity(CurrencyDTO currencyDTO) {
		
		Currency currency = new Currency();
		currency.setId(currencyDTO.getId());
		currency.setName(currencyDTO.getName());
		currency.setCode(currencyDTO.getCode());
		currency.setIsActive(currencyDTO.getIsActive());
		
		return currency;
	}
	
	public List<CurrencyDTO> allToDtos(List<Currency> currencies) {
		
		return currencies.stream().map(currency -> toDto(currency)).collect(Collectors.toList());
	}
	
	public List<Currency> allToEntity(List<CurrencyDTO> currencyDTOs) {
		
		return currencyDTOs.stream().map(currency -> toEntity(currency)).collect(Collectors.toList());
	}

}
