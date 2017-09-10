package com.myron.ProductCatalog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.ProductCatalog.models.Product;
import com.myron.ProductCatalog.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}
	
	public List<Product> findAll(){
		return (List<Product>) productRepository.findAll();
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
	
}
