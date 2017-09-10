package com.myron.DojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.DojoOverflow.models.Tag;
import com.myron.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public void addTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	public Tag findTagBySubject(String subject) {
		return tagRepository.findOneBySubjectIs(subject);
	}
	
	public List<Tag> getAllTags() {
		return (List<Tag>) tagRepository.findAll();
	}
}
