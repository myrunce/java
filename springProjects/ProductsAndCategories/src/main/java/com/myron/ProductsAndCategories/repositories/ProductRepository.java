package com.myron.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
