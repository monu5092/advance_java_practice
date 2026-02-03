package com.kodewala.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.product.entity.Product;
import com.kodewala.product.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return productRepository.save(product);
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id)
	{
		return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not Found by this Id"));
	}
	
	@GetMapping("/all")
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
}
