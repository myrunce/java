package com.myron.BrightIdeas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.BrightIdeas.models.Idea;
import com.myron.BrightIdeas.models.User;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findByAuthor(User author);
}
