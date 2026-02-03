package com.kodewala.productcache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import com.kodewala.productcache.entity.Product;
import com.kodewala.productcache.exception.ProductNotFoundException;
import com.kodewala.productcache.repository.ProductInterface;
import com.kodewala.productcache.repository.ProductRepository;

public class ProductService implements ProductInterface{
	
	@Autowired
	ProductRepository repository;
	

	@Override
	@Cacheable(value="product",key="#id")
	public Product getProductById(Long id) {
		
		return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
	}

	@Override
	@Cacheable(value="product-category",key="#category")
	public List<Product> getProductByCategory(String category) {
		
		return repository.findByCategory(category) ;
	}

	@Override
	@CachePut(value="product",key="#product.id")
	@CacheEvict(value="product-category",allEntries = true)
	public Product updateProduct(Product product) {
		
		return repository.save(product);
	}

	@Override
	@Caching(evict = {
	        @CacheEvict(value = "product", key = "#id"),
	        @CacheEvict(value = "product-category", allEntries = true)
	})
	public void deleteProduct(Long id) {
		repository.deleteById(id);
		
	}

}
