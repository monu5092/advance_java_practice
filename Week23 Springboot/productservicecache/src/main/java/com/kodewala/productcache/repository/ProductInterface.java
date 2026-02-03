package com.kodewala.productcache.repository;

import java.util.List;

import com.kodewala.productcache.entity.Product;

public interface ProductInterface {
    Product getProductById(Long id);
    
    List<Product> getProductByCategory(String category);
    
    Product updateProduct(Product product);
    
    void deleteProduct(Long id);
    
}
