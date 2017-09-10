package com.myron.BrightIdeas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.BrightIdeas.models.Idea;
import com.myron.BrightIdeas.models.User;
import com.myron.BrightIdeas.repositories.IdeaRepository;

@Service
public class IdeaService {
	private IdeaRepository ideaRepository;
	
	public IdeaService(IdeaRepository ideaRepository) {
		this.ideaRepository = ideaRepository;
	}
	
	public void addIdea(Idea idea) {
		ideaRepository.save(idea);
	}
	
	public List<Idea> allIdeas(){
		return (List<Idea>) ideaRepository.findAll();
	}
	
	public Idea findIdea(Long id) {
		return ideaRepository.findOne(id);
	}
	
	public void updateIdea(Idea idea) {
		ideaRepository.save(idea);
	}
	
	public List<Idea> findAllByAuthor(User author){
		return ideaRepository.findByAuthor(author);
	}
	
	public void deleteIdea(Idea idea) {
		ideaRepository.delete(idea);
	}
}
