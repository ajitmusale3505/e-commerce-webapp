package com.jsp.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce.entity.Products;

public interface CartItemRepo  extends JpaRepository<Products, String>{
	
}