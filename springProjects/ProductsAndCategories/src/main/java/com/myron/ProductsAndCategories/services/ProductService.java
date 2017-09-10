package com.myron.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.ProductsAndCategories.models.Product;
import com.myron.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> allProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	public Product findProductById(Long id) {
		return productRepository.findOne(id);
	}
}
