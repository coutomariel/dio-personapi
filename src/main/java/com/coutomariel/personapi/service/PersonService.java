package com.coutomariel.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coutomariel.personapi.controller.dto.request.PersonDTO;
import com.coutomariel.personapi.entity.Person;
import com.coutomariel.personapi.exception.PersonNotFoundException;
import com.coutomariel.personapi.repository.PersonRepository;

import javassist.NotFoundException;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional
	public Long savePerson(PersonDTO personDto) {
		Person personToSave = personDto.toModel();
		return personRepository.save(personToSave).getId();
	}

	@Transactional
	public void deletePersonById(Long id) throws NotFoundException {
		if (personExistsById(id)) {
			personRepository.deleteById(id);
			;
		}
	}

	private boolean personExistsById(Long id) throws NotFoundException {
		return findPersonById(id) != null;
	}

	public PersonDTO updatePerson(Long id, PersonDTO personDTO) throws NotFoundException {
		Person personUpdated = null;

		if (personExistsById(id)) {
			personDTO.setId(id);
			personUpdated = personRepository.save(personDTO.toModel());
		}

		return personUpdated.toDto();
	}

	public PersonDTO findById(Long id) throws NotFoundException {
		Person person = findPersonById(id);
		return person.toDto();
	}

	public List<PersonDTO> getAll() {
		return personRepository.findAll().stream().map(p -> p.toDto()).collect(Collectors.toList());
	}

	private Person findPersonById(Long id) throws NotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found with ID "));
	}

}
