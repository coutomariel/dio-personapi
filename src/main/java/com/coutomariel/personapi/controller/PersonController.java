package com.coutomariel.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coutomariel.personapi.controller.dto.MessageResponseDto;
import com.coutomariel.personapi.controller.dto.request.PersonDTO;
import com.coutomariel.personapi.service.PersonService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MessageResponseDto createPerson(@RequestBody @Valid PersonDTO personDTO) {
		Long personId = personService.savePerson(personDTO);
		return MessageResponseDto.builder().message("Create person with ID " + personId).build();
	}
	
	@PutMapping("/{id}")
	public PersonDTO updatePerson(@PathVariable("id") Long id, @RequestBody @Valid PersonDTO personDTO) throws NotFoundException {
		return personService.updatePerson(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable("id") Long id) throws NotFoundException{
		personService.deletePersonById(id);
	}
	
	@GetMapping("/{id}")
	public PersonDTO getPersonById(@PathVariable("id") Long id) throws NotFoundException {
		return personService.findById(id);
	}

	@GetMapping
	public List<PersonDTO> getAllPerson(){
		return personService.getAll();
	}
	
}
