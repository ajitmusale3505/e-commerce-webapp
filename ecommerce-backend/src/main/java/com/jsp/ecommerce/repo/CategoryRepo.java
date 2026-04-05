package com.jsp.ecommerce.repo;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce.entity.Products;

public interface CategoryRepo  extends JpaRepository<com.jsp.ecommerce.entity.Category, String>{
	
}