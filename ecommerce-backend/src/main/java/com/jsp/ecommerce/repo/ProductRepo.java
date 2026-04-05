package com.jsp.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce.entity.Products;
import com.jsp.ecommerce.entity.Users;

public interface ProductRepo extends JpaRepository<Products, String>{

}
