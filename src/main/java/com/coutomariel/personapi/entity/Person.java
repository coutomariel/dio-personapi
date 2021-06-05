package com.coutomariel.personapi.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.coutomariel.personapi.controller.dto.request.PersonDTO;
import com.coutomariel.personapi.controller.dto.request.PhoneDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false, unique = true)
	private String cpf;
	private LocalDate birthDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private List<Phone> phones;

	public PersonDTO toDto() {

		List<PhoneDTO> list = phones.stream().map(p -> p.toDto()).collect(Collectors.toList());

		return PersonDTO.builder().id(id).firstName(firstName).lastName(lastName).cpf(cpf).birthDate(birthDate)
				.phones(list).build();
	}

}
