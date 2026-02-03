package com.kodekart.service;

import java.util.List;

import com.kodekart.dao.ProductDao;
import com.kodekart.model.Product;

public class ProductService {
    private ProductDao productDao = new ProductDao();
    
    public boolean addProduct(Product product)
    {
    	return productDao.addProduct(product);
    }
    
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }
    
    public boolean deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }
    
     public List<Product> viewAllProduct()
     {
    	 return productDao.getAllProducts();
     }
     
     public Product getProductById(int id) {
         return productDao.getProductById(id);
     }
     
     public List<Product> searchProduct(String name) {
         return productDao.searchProduct(name);
     }
}
