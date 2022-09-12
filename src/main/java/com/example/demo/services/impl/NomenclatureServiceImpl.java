package com.example.demo.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.CountryDTO;
import com.example.demo.dtos.CurrencyDTO;
import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;
import com.example.demo.mappers.CountryMapper;
import com.example.demo.mappers.CurrencyMapper;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.CurrencyRepository;
import com.example.demo.services.NomenclatureService;

@Service
public class NomenclatureServiceImpl implements NomenclatureService{
	
	private CurrencyRepository currencyRepository;
	private CurrencyMapper currencyMapper;
	private CountryRepository countryRepository;
	private CountryMapper countryMapper;
	
	@Autowired
	public NomenclatureServiceImpl(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper, 
			CountryRepository countryRepository, CountryMapper countryMapper) {
		this.currencyMapper = currencyMapper;
		this.currencyRepository = currencyRepository;
		this.countryMapper = countryMapper;
		this.countryRepository = countryRepository;
	}
	
	@Transactional
	@Override
	public List<CurrencyDTO> getCurrencies() {
		
		return currencyMapper.allToDtos(currencyRepository.findAll());
	}

	@Override
	public List<CountryDTO> getCountries() {
	
		return countryMapper.allToDtos(countryRepository.findAll());
	}

	@Override
	public List<ContractorType> getContractorTypes() {
		ContractorType[] contractorTypes = ContractorType.values();
		return Arrays.asList(contractorTypes);
	}

	@Override
	public List<LegalType> getLegalTypes() {
		LegalType[] legalTypes = LegalType.values();
		return Arrays.asList(legalTypes);
	}

	
	
}
