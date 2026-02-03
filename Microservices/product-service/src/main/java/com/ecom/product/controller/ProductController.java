package com.ecom.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.entity.Product;
import com.ecom.product.request.ProductRequest;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
      
	@Autowired
	ProductService productService;
	
	@PostMapping("create")
	public ResponseEntity<Product> create(@RequestBody ProductRequest productRequest)
	{
		return new ResponseEntity<>(productService.createProduct(productRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id)
	{
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	
	 
}
