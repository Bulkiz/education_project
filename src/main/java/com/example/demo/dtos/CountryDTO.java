package com.example.demo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CountryDTO {
	
	@Schema(example = "2")
	private Integer id;
	@Schema(example = "Bulgaria")
	private String name;
	@Schema(example = "true")
	private Boolean isActive;
}
