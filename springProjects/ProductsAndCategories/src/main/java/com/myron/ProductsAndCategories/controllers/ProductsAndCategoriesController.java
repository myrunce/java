package com.myron.ProductsAndCategories.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myron.ProductsAndCategories.models.Category;
import com.myron.ProductsAndCategories.models.Product;
import com.myron.ProductsAndCategories.services.CategoryService;
import com.myron.ProductsAndCategories.services.ProductService;

@Controller
public class ProductsAndCategoriesController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductsAndCategoriesController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/add")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
            return "redirect:/products/new";
        }else{
        	System.out.println("ADDING PRODUCT");
            productService.addProduct(product);
            return "redirect:/products/new";
        }
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/add")
	public String addProduct(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
            return "redirect:/categories/new";
        }else{
        	System.out.println("ADDING CATEGORY");
            categoryService.addCategory(category);
            return "redirect:/categories/new";
        }
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model, @PathVariable("id") Long id) {
		List<Category> categories = categoryService.allCategories();
		Product theProduct = productService.findProductById(id);
		List<Category> pCategories = theProduct.getCategories();
		for(int i = 0; i < pCategories.size(); i ++) {
			for(int j = 0; j < categories.size(); j++) {
				if (pCategories.get(i) == categories.get(j)){
					categories.remove(j);
				}
			}
		}
		model.addAttribute("product", theProduct);
		model.addAttribute("categories", categories);
		return "oneProduct.jsp";
	}
	
	@PostMapping("/products/{id}/addCategory")
	public String addProductCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model, @PathVariable("id") Long id, @RequestParam("name") Long cId){
		if (result.hasErrors()) {
			System.out.println(result);
            return "redirect:/products/" + id;
        }else{
        	System.out.println("ADDING CATEGORY TO PRODUCT");
        	Category theCategory = categoryService.findCategoryById(cId);
            Product theProduct = productService.findProductById(id);
            theProduct.getCategories().add(theCategory);
            productService.addProduct(theProduct);
            return "redirect:/products/" + id;
        }
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, @PathVariable("id") Long id) {
		List<Product> products = productService.allProducts();
		Category theCategory = categoryService.findCategoryById(id);
		List<Product> cProducts = theCategory.getProducts();
		for(int i = 0; i < cProducts.size(); i ++) {
			for(int j = 0; j < products.size(); j++) {
				if (cProducts.get(i) == products.get(j)){
					products.remove(j);
				}
			}
		}
		model.addAttribute("category", theCategory);
		model.addAttribute("products", products);
		return "oneCategory.jsp";
	}
	
	@PostMapping("/categories/{id}/addProduct")
	public String addCategoryProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, @PathVariable("id") Long id, @RequestParam("name") Long pId){
		if (result.hasErrors()) {
			System.out.println(result);
            return "redirect:/categories/" + id;
        }else{
        	System.out.println("ADDING PRODUCT TO CATEGORY");
        	Product theProduct = productService.findProductById(pId);
            Category theCategory = categoryService.findCategoryById(id);
            theCategory.getProducts().add(theProduct);
            categoryService.addCategory(theCategory);
            return "redirect:/categories/" + id;
        }
	}
}
