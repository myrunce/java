package com.myron.BrightIdeas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.BrightIdeas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
