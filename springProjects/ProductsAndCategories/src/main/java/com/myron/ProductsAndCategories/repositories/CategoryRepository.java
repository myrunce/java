package com.myron.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.ProductsAndCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
