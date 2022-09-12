package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.BankAccountDTO;
import com.example.demo.entities.BankAccount;

@Component
public class BankAccountMapper implements ModelMapper<BankAccountDTO, BankAccount>{
	
	@Autowired private CurrencyMapper currencyMapper;
	
	public BankAccountDTO toDto(BankAccount bankAccount) {
	
		return BankAccountDTO.builder().
				id(bankAccount.getId()).
				name(bankAccount.getName()).
				swift(bankAccount.getSwift()).
				iban(bankAccount.getIban()).
				currency(currencyMapper.toDto(bankAccount.getCurrency())).
				address(bankAccount.getAddress()).
				isActive(bankAccount.getIsActive()).
				build();
	}
	
	public BankAccount toEntity(BankAccountDTO bankAccountDTO) {

		return BankAccount.builder().
				id(bankAccountDTO.getId()).
				name(bankAccountDTO.getName()).
				swift(bankAccountDTO.getSwift()).
				iban(bankAccountDTO.getIban()).
				currency(currencyMapper.toEntity(bankAccountDTO.getCurrency())).
				address(bankAccountDTO.getAddress()).
				isActive(bankAccountDTO.getIsActive()).
				build();
	}
	
	public List<BankAccountDTO> allToDtos(List<BankAccount> bankAccounts) {
		
		return bankAccounts.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}
	
	public List<BankAccount> allToEntities(List<BankAccountDTO> bankAccountDTOs) {
		
		return bankAccountDTOs.stream().map(x -> toEntity(x)).collect(Collectors.toList());
	}

}
