package com.myron.Relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.Relationships.models.Person;
import com.myron.Relationships.repositories.PersonRepository;

@Service
public class PersonService {
private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	
	public List<Person> allPersons(){
		return (List<Person>) personRepository.findAll();
	}
	
}
