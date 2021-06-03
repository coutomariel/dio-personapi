package com.coutomariel.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coutomariel.personapi.controller.dto.MessageResponseDto;
import com.coutomariel.personapi.entity.Person;
import com.coutomariel.personapi.service.PersonService;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MessageResponseDto createPerson(@RequestBody Person person) {
		Long personId = personService.savePerson(person);
		return MessageResponseDto
				.builder()
				.message("Create person with ID " + personId)
				.build();
	}
}
