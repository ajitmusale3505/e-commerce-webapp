package com.jsp.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ecommerce.entity.Products;
import com.jsp.ecommerce.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Products insertProduct(Products prod) {
		return  repo.save(prod);
	}

	@Override
	public List<Products> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Products getProdById(String id) {
		return  repo.findById(id).get();
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	@Override
	public Products updateAll(Products prod) {
		return repo.save(prod);
	}

	@Override
	public Products updateByIdName(String id, String name) {
		 Products prod = repo.findById(id).get();
		 prod.setName(name);
		
		return   repo.save(prod);
	}

	@Override
	public Products updateByIdPrice(String id, double price) {
		Products products = repo.findById(id).get();
		products.setPrice(price);
		return repo.save(products);
	}

}
