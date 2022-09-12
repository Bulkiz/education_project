package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.ContactDTO;
import com.example.demo.entities.Contact;

@Component
public class ContactMapper implements ModelMapper<ContactDTO, Contact> {
	
	public ContactDTO toDto(Contact contact) {

		return ContactDTO.builder().
				id(contact.getId()).
				name(contact.getName()).
				contactType(contact.getContactType()).
				department(contact.getDepartment()).
				phoneNumber(contact.getPhoneNumber()).
				email(contact.getEmail()).
				isActive(contact.getIsActive()).
				build();
	}
	
	public Contact toEntity(ContactDTO contactDTO) {
		
		return Contact.builder().
				id(contactDTO.getId()).
				name(contactDTO.getName()).
				contactType(contactDTO.getContactType()).
				department(contactDTO.getDepartment()).
				phoneNumber(contactDTO.getPhoneNumber()).
				email(contactDTO.getEmail()).
				isActive(contactDTO.getIsActive()).
				build();
	}
	
	public List<ContactDTO> allToDtos(List<Contact> contacts) {
		
		return contacts.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}
	
	public List<Contact> allToEntities(List<ContactDTO> contactDTOs) {
		
		return contactDTOs.stream().map(x -> toEntity(x)).collect(Collectors.toList());
	}
	
}
