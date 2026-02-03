package com.kodewala.productcache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.productcache.entity.Product;
import com.kodewala.productcache.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
     
	 @Autowired
	 ProductService productService;
	 
	    @GetMapping("/{id}")
	    public Product getProduct(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @GetMapping("/category/{category}")
	    public List<Product> getByCategory(@PathVariable String category) {
	        return productService.getProductByCategory(category);
	    } 
}
