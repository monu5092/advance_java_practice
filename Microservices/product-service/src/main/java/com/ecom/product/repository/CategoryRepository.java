package com.ecom.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.product.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByCategoryNameIgnoreCase(String categoryName);
}
