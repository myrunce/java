package com.myron.DojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.DojoOverflow.models.Answer;
import com.myron.DojoOverflow.models.Question;
import com.myron.DojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	}
	
	public List<Answer> getAnswersForQuestion(Question question) {
		return answerRepository.findByQuestion(question);
	}
}
