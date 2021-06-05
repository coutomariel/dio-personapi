package com.coutomariel.personapi.controller.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.coutomariel.personapi.entity.Phone;
import com.coutomariel.personapi.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

	private Long id;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@NotBlank
	@Size(min = 13, max = 14)
	private String number;

	public Phone toModel() {
		return Phone.builder().type(type).number(number).build();
	}
}
