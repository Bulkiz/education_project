package com.example.demo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankAccountDTO {
	
	private Integer id;
	@NotBlank(message = "Bank account name cannot be empty")
	@Size(min = 3, max = 100, message = "Bank account name must be between 3 and 100 characters")
	private String name;
	@NotBlank(message = "SWIFT code cannot be empty")
	@Pattern(regexp = "^([a-zA-Z]){6}([0-9a-zA-Z]){2}([0-9a-zA-Z]{3})?$", message = "Invalid SWIFT code")
	private String swift;
	@NotBlank(message = "IBAN cannot be empty")
	@Pattern(regexp = "^([A-Z]{2}[ \\-]?[0-9]{2})(?=(?:[ \\-]?[A-Z0-9]){9,30}$)((?:[ \\-]?[A-Z0-9]{3,5}){2,7})([ \\-]?[A-Z0-9]{1,3})?$",
	message = "Invalid IBAN")
	private String iban;
	@NotNull(message = "Currency cannot be empty")
	private CurrencyDTO currency;
	@NotNull(message = "You should provide bank address")
	@Size(max = 200, message = "Bank address can be up to 200 characters")
	private String address;
	@NotNull(message = "Bank account active status is missing")
	private Boolean isActive;

}
