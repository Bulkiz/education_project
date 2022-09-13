package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;
import com.example.demo.utils.PageCustom;

public interface ContractorService {
	
	public PageCustom<ContractorDTO> findAll(Integer id, String code, String name, Boolean isActive,
			ContractorType contractorType, LegalType legalType, String pin, Integer page, Integer size,
			List<String> sortBys, List<Sort.Direction> sortDirections);
	
	public ContractorDTO saveContractor(ContractorDTO contractorDTO);
	
	public ContractorDTO updateContractor(ContractorDTO contractorDTO);
	
}