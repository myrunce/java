package com.myron.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.ProductsAndCategories.models.Category;
import com.myron.ProductsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> allCategories(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public Category findCategoryById(Long id) {
		return categoryRepository.findOne(id);
	}
	
//	public void addProductToCategory(Long id) {
//		Category category = categoryRepository.findOne(id);
//		category.setProducts(products);
//	}
}
