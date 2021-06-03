package com.coutomariel.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coutomariel.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
