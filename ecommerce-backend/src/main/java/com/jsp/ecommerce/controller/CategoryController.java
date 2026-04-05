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

import com.jsp.ecommerce.entity.Category;
import com.jsp.ecommerce.entity.Users;
import com.jsp.ecommerce.service.CategoryService;

@Controller
@RequestMapping("/ecommerce/category/")
public class CategoryController {

	@Autowired 
	CategoryService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> insert() {
		return new ResponseEntity<List<Category>>(service.getAllCategory(),  HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/")
	public ResponseEntity<Category> save(@RequestBody Category cateogry) {
		return new ResponseEntity<>(service.insertCategory(cateogry), HttpStatusCode.valueOf(201));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getAllData(@PathVariable String id){
		return new ResponseEntity<Category>(service.getByData(id), HttpStatusCode.valueOf(200));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteById(@PathVariable String id){
		service.deleteById(id);
		return new ResponseEntity<Category>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/")
	public ResponseEntity<Category> updateAll(@RequestBody Category category){
		return new ResponseEntity<Category>(service.updateAll(category), HttpStatusCode.valueOf(200));
	}
	
	@PatchMapping("/upd-n/{id}/{name}")
	public ResponseEntity<Category> deleteById(@PathVariable String id, @PathVariable String name){
		return new ResponseEntity<Category>(service.updateById(id,name), HttpStatusCode.valueOf(200));
	}
	
	@PatchMapping("/upd-d/{id}/{description}")
	public ResponseEntity<Category> deleteByIdDesc(@PathVariable String id, @PathVariable String description){
		return new ResponseEntity<Category>(service.updateById(id,description), HttpStatusCode.valueOf(200));
	}
	
}
