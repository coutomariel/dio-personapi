package com.coutomariel.personapi.controller.dto.request;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.coutomariel.personapi.entity.Person;
import com.coutomariel.personapi.entity.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

	private Long id;

	@NotBlank
	@Size(min = 2, max = 100)
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 100)
	private String lastName;

	@NotBlank
	@CPF
	private String cpf;

	private LocalDate birthDate;

	@Valid
	@NotEmpty
	private List<PhoneDTO> phones;

	public Person toModel() {

		List<Phone> p = phones.stream().map(phone -> phone.toModel()).collect(Collectors.toList());

		return Person.builder().id(id).firstName(firstName).lastName(lastName).cpf(cpf)
				.birthDate(birthDate).phones(p).build();
	}

}
