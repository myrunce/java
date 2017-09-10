package com.myron.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.DojoOverflow.models.Answer;
import com.myron.DojoOverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository <Answer, Long> {
	List<Answer> findByQuestion(Question question);
}
