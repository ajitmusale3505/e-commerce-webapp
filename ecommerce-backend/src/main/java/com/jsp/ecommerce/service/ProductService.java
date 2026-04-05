package com.jsp.ecommerce.service;

import java.util.List;

import com.jsp.ecommerce.entity.Category;
import com.jsp.ecommerce.entity.Products;

public interface ProductService {
	public Products insertProduct(Products prod);
	public List<Products> getAllProducts();
	public Products getProdById(String id);
	public void deleteById(String id);
	public Products updateAll(Products prod);
    public Products updateByIdName(String id, String name);
    public Products updateByIdPrice(String id, double price);
}
