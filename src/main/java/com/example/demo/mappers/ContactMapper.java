package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.ContactDTO;
import com.example.demo.entities.Contact;

@Component
public class ContactMapper {
	
	
	public ContactDTO toDto(Contact contact) {
		
		ContactDTO contactDTO = new ContactDTO();
		contactDTO.setId(contact.getId());
		contactDTO.setName(contact.getName());
		contactDTO.setContactType(contact.getContactType());
		contactDTO.setDepartment(contact.getDepartment());
		contactDTO.setPhoneNumber(contact.getPhoneNumber());
		contactDTO.setEmail(contact.getEmail());
		contactDTO.setIsActive(contact.getIsActive());
		
		return contactDTO;
	}
	
	public Contact toEntity(ContactDTO contactDTO) {
		
		Contact contact = new Contact();
		contact.setId(contactDTO.getId()); 
		contact.setName(contactDTO.getName());
		contact.setContactType(contactDTO.getContactType());
		contact.setDepartment(contactDTO.getDepartment());
		contact.setPhoneNumber(contactDTO.getPhoneNumber());
		contact.setEmail(contactDTO.getEmail());
		contact.setIsActive(contactDTO.getIsActive());
		
		return contact;
	}
	
	public List<ContactDTO> allToDtos(List<Contact> contacts) {
		
		return contacts.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}
	
	public List<Contact> allToEntity(List<ContactDTO> contactDTOs) {
		
		return contactDTOs.stream().map(x -> toEntity(x)).collect(Collectors.toList());
	}
	

	
	
	
}
