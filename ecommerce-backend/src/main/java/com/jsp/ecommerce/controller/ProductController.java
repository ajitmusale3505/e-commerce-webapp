package com.jsp.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.ecommerce.entity.Products;
import com.jsp.ecommerce.entity.Users;
import com.jsp.ecommerce.service.ProductService;

@Controller
@RequestMapping("/ecommerce/products/")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Products>> insert() {
		return new ResponseEntity<List<Products>>(service.getAllProducts(),  HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/")
	public ResponseEntity<Products> save(@RequestBody Products prod) {
		return new ResponseEntity<>(service.insertProduct(prod), HttpStatusCode.valueOf(201));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> getAllData(@PathVariable String id){
		return new ResponseEntity<Products>(service.getProdById(id), HttpStatusCode.valueOf(200));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Products> deleteById(@PathVariable String id){
		service.deleteById(id);
		return new ResponseEntity<Products>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/")
	public ResponseEntity<Products> updateAll(@RequestBody Products prod){
		return new ResponseEntity<Products>(service.updateAll(prod), HttpStatusCode.valueOf(200));
	}
	
	@PatchMapping("/{id}/{name}")
	public ResponseEntity<Products> deleteById(@PathVariable String id, @PathVariable String name){
		return new ResponseEntity<Products>(service.updateByIdName(id,name), HttpStatusCode.valueOf(200));
	}
	
	@PatchMapping("/{id}/{price}/")
	public ResponseEntity<Products> updateById(@PathVariable String id, @PathVariable double price){
		return new ResponseEntity<Products>(service.updateByIdPrice(id,price), HttpStatusCode.valueOf(200));
	}
	
}
