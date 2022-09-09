package com.example.demo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.enums.AddressType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
	

	private Integer id;
	@NotNull(message = "Country cannot be empty")
	private CountryDTO country;
	@NotNull
	private AddressType addressType;
	@NotBlank(message = "City cannot be empty")
	@Size(min = 3, max = 50, message = "City must be between 3 and 50 characters")
	private String city;
	@NotBlank(message = "Postcode cannot be empty")
	@Size(min = 3, max = 20, message = "Postcode must be between 3 and 20 characters")
	private String postCode;
	@NotBlank(message = "Street address cannot be empty")
	@Size(max = 200,message = "Street address can be up to 200 characters")
	private String streetAddress;

}
