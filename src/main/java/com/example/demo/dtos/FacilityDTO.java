package com.example.demo.dtos;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FacilityDTO {
	
	private Integer id;
	@NotNull
	@Size(max = 7)
	private String code;
	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 100,  message = "Name must be between 3 and 100 characters")
	private String name;
	@NotNull(message = "Facility active status is missing")
	private Boolean isActive;
	@NotNull(message = "You should provide facility address")
	private AddressDTO facilityAddress;
	@NotNull(message = "You should provide one or more facility contacts")
	@Valid
	private List<ContactDTO> contacts;
}
