package com.coutomariel.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coutomariel.personapi.entity.Person;
import com.coutomariel.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	
	public Long savePerson(Person person) {
		return personRepository.save(person).getId();
	}
	

}
