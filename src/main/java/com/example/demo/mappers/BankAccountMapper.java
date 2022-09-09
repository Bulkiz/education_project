package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.BankAccountDTO;
import com.example.demo.entities.BankAccount;

@Component
public class BankAccountMapper {
	
	@Autowired private CurrencyMapper currencyMapper;
	
	public BankAccountDTO toDto(BankAccount bankAccount) {
		
		BankAccountDTO bankAccountDTO = new BankAccountDTO();
		bankAccountDTO.setId(bankAccount.getId());
		bankAccountDTO.setName(bankAccount.getName());
		bankAccountDTO.setSwift(bankAccount.getSwift());
		bankAccountDTO.setIban(bankAccount.getIban());
		bankAccountDTO.setCurrency(currencyMapper.toDto(bankAccount.getCurrency()));
		bankAccountDTO.setAddress(bankAccount.getAddress());
		bankAccountDTO.setIsActive(bankAccount.getIsActive());
		
		return bankAccountDTO;
	}
	
	public BankAccount toEntity(BankAccountDTO bankAccountDTO) {
		
		BankAccount bankAccount = new BankAccount();
		bankAccount.setId(bankAccountDTO.getId());
		bankAccount.setName(bankAccountDTO.getName());
		bankAccount.setSwift(bankAccountDTO.getSwift());
		bankAccount.setIban(bankAccountDTO.getIban());
		bankAccount.setCurrency(currencyMapper.toEntity(bankAccountDTO.getCurrency()));
		bankAccount.setAddress(bankAccountDTO.getAddress());
		bankAccount.setIsActive(bankAccountDTO.getIsActive());
		
		return bankAccount;
	}
	
	public List<BankAccountDTO> allToDtos(List<BankAccount> bankAccounts) {
		
		return bankAccounts.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}
	
	public List<BankAccount> allToEntity(List<BankAccountDTO> bankAccountDTOs) {
		
		return bankAccountDTOs.stream().map(x -> toEntity(x)).collect(Collectors.toList());
	}

}
