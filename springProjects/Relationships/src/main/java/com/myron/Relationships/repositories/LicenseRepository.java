package com.myron.Relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.Relationships.models.License;


@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	License findFirstByOrderByIdDesc();
}