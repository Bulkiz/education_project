package com.example.demo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.enums.ContactType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactDTO {
	
	private Integer id;
	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;
	@NotNull(message = "Contact type cannot be empty")
	private ContactType contactType;
	@NotBlank(message = "Department cannot be empty")
	@Size(min = 3, max = 50, message = "Department must be between 3 and 50 characters")
	private String department;
	@NotBlank(message = "Phone number cannot be empty")
	@Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", message = "Invalid phone number")
	private String phoneNumber;
	@Pattern(message = "Email is not valid", regexp = "^[A-Za-z0-9+_.]+@(.+)$")
	@Size(max = 100)
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	@NotNull(message = "Contact active status is missing")
	private Boolean isActive;

}
