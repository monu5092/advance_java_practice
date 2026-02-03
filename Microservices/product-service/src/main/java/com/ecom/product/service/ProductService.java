package com.ecom.product.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.product.entity.Category;
import com.ecom.product.entity.Product;
import com.ecom.product.repository.CategoryRepository;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.request.ProductRequest;

@Service
public class ProductService {
     
	   @Autowired
	   ProductRepository productRepository;
	   
	   @Autowired
	   CategoryRepository categoryRepository;
	   
	   public Product createProduct(ProductRequest request)
	   {
		   if (request.getCategoryName() == null || request.getCategoryName().isBlank()) {
	            throw new RuntimeException("Category name is required");
	        }
		   
		   Category category = categoryRepository.
			      findByCategoryNameIgnoreCase(request.getCategoryName())
			        .orElseGet(() -> {
			            Category c = new Category();
			            c.setCategoryName(request.getCategoryName());
			            return categoryRepository.save(c);
			        });
		    
		    Product product = new Product();
	        product.setName(request.getName());
	        product.setPrice(request.getPrice());
	        product.setCategory(category);

	        return productRepository.save(product);
		    
	   }
	   
	   public Product getProductById(Long id) {
	        return productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	    }
}
