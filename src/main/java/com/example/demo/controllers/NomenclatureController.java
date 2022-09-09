package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CountryDTO;
import com.example.demo.dtos.CurrencyDTO;
import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;
import com.example.demo.services.NomenclatureService;

import io.swagger.v3.oas.annotations.Operation;

@RestController

public class NomenclatureController {
	
	@Autowired private NomenclatureService nomenclatureService;
	
	@GetMapping("/currencies") 
	@ResponseBody
	@Operation(summary = "Find all currencies", tags = "Nomenclatures")
	public ResponseEntity<List<CurrencyDTO>> getCurrencies() {
		
		return ResponseEntity.ok(nomenclatureService.getCurrencies());
	}
	
	@GetMapping("/countries")
	@ResponseBody
	@Operation(summary = "Find all countries", tags = "Nomenclatures")
	public ResponseEntity<List<CountryDTO>> getCountries() {
		
		return ResponseEntity.ok(nomenclatureService.getCountries());
	}
	
	@GetMapping("/contractorTypes")
	@ResponseBody
	@Operation(summary = "Find all contractor types", tags = "Nomenclatures")
	public ResponseEntity<List<ContractorType>> getContractorTypes() {
		
		return ResponseEntity.ok(nomenclatureService.getContractorTypes());
	}
	
	@GetMapping("/legalTypes")
	@ResponseBody
	@Operation(summary = "Find all legal types", tags = "Nomenclatures")
	public ResponseEntity<List<LegalType>> getLegalTypes() {
		
		return ResponseEntity.ok(nomenclatureService.getLegalTypes());
	}
}
