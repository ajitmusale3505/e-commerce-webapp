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
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ecommerce.entity.Users;
import com.jsp.ecommerce.service.UserService;

@RestController
@RequestMapping("/ecommerce/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Users>> insert() {
		return new ResponseEntity<List<Users>>(service.getAllUsers(),  HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/")
	public ResponseEntity<Users> save(@RequestBody Users user) {
		return new ResponseEntity<>(service.insertuser(user), HttpStatusCode.valueOf(201));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getAllData(@PathVariable String id){
		return new ResponseEntity<Users>(service.getByData(id), HttpStatusCode.valueOf(200));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Users> deleteById(@PathVariable String id){
		service.deleteById(id);
		return new ResponseEntity<Users>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/")
	public ResponseEntity<Users> updateAll(@RequestBody Users users){
		return new ResponseEntity<Users>(service.updateAll(users), HttpStatusCode.valueOf(200));
	}
	
	@PatchMapping("/{id}/{name}")
	public ResponseEntity<Users> deleteById(@PathVariable String id, @PathVariable String name){
		return new ResponseEntity<Users>(service.updateById(id,name), HttpStatusCode.valueOf(200));
	}
	
	@PatchMapping("/{id}/{email}/{password}")
	public ResponseEntity<Users> deleteById(@PathVariable String id, @PathVariable String email, @PathVariable String password){
		return new ResponseEntity<Users>(service.updateById(id,email,password), HttpStatusCode.valueOf(200));
	}
	
	
}
