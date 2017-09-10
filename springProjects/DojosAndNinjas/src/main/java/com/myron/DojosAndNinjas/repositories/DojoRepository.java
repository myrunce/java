package com.myron.DojosAndNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.DojosAndNinjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	
}
