package com.jsp.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce.entity.Order;

public interface OrderRepo  extends JpaRepository<Order, String>{
	
}