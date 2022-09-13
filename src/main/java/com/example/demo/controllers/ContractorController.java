package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;
import com.example.demo.services.ContractorService;
import com.example.demo.utils.PageCustom;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/contractors")
public class ContractorController {
	
	@Autowired private ContractorService contractorService;
	
	@GetMapping
	@Operation(summary = "Get all the contractors", description = "Find all contractors by search parameters", tags = "Contractor")
	public ResponseEntity<PageCustom<ContractorDTO>> findAllPagedContractors(
		@Parameter(description = "Id value for the contractor")	@RequestParam(required = false) Integer id,
		@Parameter(description = "Code value for the contractor") @RequestParam(required = false) String code,
		@Parameter(description = "Name value for the contractor") @RequestParam(required = false) String name,
		@Parameter(description = "Active status value for the contractor") @RequestParam(required = false) Boolean isActive,
		@Parameter(description = "Type value for the contractor") @RequestParam(required = false) ContractorType contractorType,
		@Parameter(description = "Legal type value for the contractor") @RequestParam(required = false) LegalType legalType,
		@Parameter(description = "Personal identification number value for the contractor") @RequestParam(required = false) String pin,
		@Parameter(description = "Page number you want to access") @RequestParam(required = true) Integer page,
		@Parameter(description = "Size of the page") @RequestParam(required = true) Integer size,
		@Parameter(description = "Parameter you want to sort by") @RequestParam(defaultValue = "id") List<String> sortBy,
		@Parameter(description = "Sort direction on which to sort") @RequestParam(defaultValue = "ASC") List<Sort.Direction> sortDirection
	) {
		PageCustom<ContractorDTO> contractorPage = contractorService.findAll(id, code, name, isActive, contractorType,
				legalType, pin, page, size, sortBy, sortDirection);
		
		return ResponseEntity.ok(contractorPage);
	}
	
	@PostMapping
	@Operation(summary = "Save contractor", description = "Save a new contractor with valid values", tags = "Contractor")
	public ResponseEntity<ContractorDTO> saveContractor(@Valid @RequestBody ContractorDTO contractorDTO) {
		return new ResponseEntity<>(contractorService.saveContractor(contractorDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	@Operation(summary = "Update contractor", description = "Update contractor's information by giving valid values", tags = "Contractor")
	public ResponseEntity<ContractorDTO> updateContractor(@Valid @RequestBody ContractorDTO contractorDTO) {
		return ResponseEntity.ok(contractorService.updateContractor(contractorDTO));
	}
	
	
}
