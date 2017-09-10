package com.myron.Languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.Languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
}
