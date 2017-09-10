package com.myron.Relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.Relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
