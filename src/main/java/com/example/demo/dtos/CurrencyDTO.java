package com.example.demo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CurrencyDTO {
	
	@Schema(example = "4")
	private Integer id;
	@Schema(example = "lev")
	private String name;
	@Schema(example = "bgn")
	private String code;
	@Schema(example = "true")
	private Boolean isActive;

}
