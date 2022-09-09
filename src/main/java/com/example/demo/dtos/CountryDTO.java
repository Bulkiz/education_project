package com.example.demo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
	
	@Schema(example = "2")
	private Integer id;
	@Schema(example = "Bulgaria")
	private String name;
	@Schema(example = "true")
	private Boolean isActive;
}
