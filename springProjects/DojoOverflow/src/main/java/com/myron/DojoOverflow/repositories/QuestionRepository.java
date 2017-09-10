package com.myron.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.DojoOverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
}
