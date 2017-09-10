package com.myron.ProductCatalog.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myron.ProductCatalog.models.Product;
import com.myron.ProductCatalog.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@ResponseBody
	@RequestMapping(path="/products", method=RequestMethod.GET)
	public ArrayList<Product> getProducts(){
		Product product1 = new Product();
		product1.setName("test");
		product1.setDesc("hello");
		product1.setPrice((float) 10.99);
		product1.setTimeStamp(new Date());
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(product1);
		return products;
	}
	
}
