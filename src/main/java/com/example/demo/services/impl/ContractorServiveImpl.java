package com.example.demo.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.entities.BankAccount;
import com.example.demo.entities.Contact;
import com.example.demo.entities.Contractor;
import com.example.demo.entities.Facility;
import com.example.demo.enums.AddressType;
import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;
import com.example.demo.mappers.ContractorMapper;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.BankAccountRepository;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.ContractorRepository;
import com.example.demo.repositories.FacilityRepository;
import com.example.demo.services.ContractorService;
import com.example.demo.utils.PageCustom;


@Service
public class ContractorServiveImpl implements ContractorService{
	
	private ContractorRepository contractorRepository;
	private AddressRepository addressRepository;
	private BankAccountRepository bankAccountRepository;
	private ContractorMapper contractorMapper;
	private ContactRepository contactRepository;
	private FacilityRepository facilityRepository;
	
	@Autowired
	public ContractorServiveImpl(ContractorRepository contractorRepository, AddressRepository addressRepository,
			BankAccountRepository bankAccountRepository, ContractorMapper contractorMapper, ContactRepository contactRepository, 
			FacilityRepository facilityRepository) {
		
		this.contractorRepository = contractorRepository;
		this.addressRepository = addressRepository;
		this.bankAccountRepository = bankAccountRepository;
		this.contractorMapper = contractorMapper;
		this.contactRepository = contactRepository;
		this.facilityRepository = facilityRepository;
	}
	
	@Transactional
	@Override
	public PageCustom<ContractorDTO> findAll(Integer id, String code, String name, Boolean isActive,
			ContractorType contractorType,
			LegalType legalType, String pin,
			Integer page, Integer size, List<String> sortBys,
			List<Sort.Direction> sortDirections) {
			
		List<Order> orders = new ArrayList<>();
		if (!sortBys.isEmpty()) {
			if (sortBys.size() == sortDirections.size()) {
				for (int i = 0; i < sortBys.size(); i++) {
					orders.add(new Order(sortDirections.get(i), sortBys.get(i)));
				}
			}
		}
		Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

		Page<ContractorDTO> contractorPage = contractorRepository.findAllPaged(id, code, name,
				isActive,
				contractorType,
				legalType, pin, pagingSort)
				.map(contractor -> contractorMapper.toDtoBasicInfo(contractor));

		return new PageCustom<>(contractorPage);
	}
	
	@Transactional
	@Override
	public ContractorDTO findById(Integer id) {
		try {
			return contractorMapper.toDto(contractorRepository.findById(id).get());
		} catch (Exception e) {
			throw new NotFoundException("There is no contractor with provided id: " + id);
		}
		
		
	}
	
	@Transactional
	@Override
	public ContractorDTO saveContractor(ContractorDTO contractorDTO) {
		Contractor contractor = contractorMapper.toEntity(contractorDTO);
		contractor.getCorrespondenceAddress().setAddressType(AddressType.CORRESPONDENCE);
		addressRepository.save(contractor.getCorrespondenceAddress());
		contractor.getInvoiceAddress().setAddressType(AddressType.INVOICE);
		addressRepository.save(contractor.getInvoiceAddress());
		contractor.getRegistrationAddress().setAddressType(AddressType.REGISTRATION);
		addressRepository.save(contractor.getRegistrationAddress());
		
		contractor.setRegistrationTime(LocalDateTime.now());
		contractorRepository.save(contractor);
		
		List<BankAccount> bankAccounts = contractor.getBankAccounts();
		bankAccounts.forEach(bankAccount -> bankAccount.setContractor(contractor));
		bankAccountRepository.saveAll(bankAccounts);
		
		List<Contact> contacts = contractor.getContacts();
		contacts.forEach(contact -> contact.setContractor(contractor));
		contactRepository.saveAll(contacts);
		
		List<Facility> facilities = contractor.getFacilities();
		for(Facility facility : facilities) {
			List<Contact> facilityContacts = facility.getContacts();
			facility.setContractor(contractor);
			facility.getFacilityAddress().setAddressType(AddressType.FACILITY);
			addressRepository.save(facility.getFacilityAddress());
			facilityContacts.forEach(contact -> contact.setFacility(facility));
			facilityRepository.save(facility);
			facilityContacts.forEach(contact -> contactRepository.save(contact));
		}

		return contractorMapper.toDto(contractor);
	}
	
	@Transactional
	@Override
	public ContractorDTO updateContractor(ContractorDTO contractorDTO) {
		Contractor contractor = contractorMapper.toEntity(contractorDTO);
		
		return saveContractor(contractorMapper.toDto(contractor));
	}

	
	

	
	
	
	
	
}
