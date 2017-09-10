package com.myron.DojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.DojoOverflow.models.Question;
import com.myron.DojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public List<Question> allQuestions(){
		return (List<Question>) questionRepository.findAll();
	}
	
	public Question findQuestionById(Long id) {
		return questionRepository.findOne(id);
	}
	
	public void updateQuestion(Question question) {
		questionRepository.save(question);
	}
}
