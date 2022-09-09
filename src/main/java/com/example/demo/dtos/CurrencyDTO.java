package com.example.demo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
