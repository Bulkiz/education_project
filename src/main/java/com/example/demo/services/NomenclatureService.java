package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.CountryDTO;
import com.example.demo.dtos.CurrencyDTO;
import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;

public interface NomenclatureService {

	public List<CurrencyDTO> getCurrencies();

	public List<CountryDTO> getCountries();

	public List<ContractorType> getContractorTypes();

	public List<LegalType> getLegalTypes();
	
}
