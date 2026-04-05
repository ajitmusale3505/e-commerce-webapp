package com.jsp.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce.entity.Products;

public interface CartRepo  extends JpaRepository<Products, String>{
	
}