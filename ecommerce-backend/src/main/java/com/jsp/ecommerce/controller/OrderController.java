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

import com.jsp.ecommerce.entity.Order;
import com.jsp.ecommerce.entity.OrderItem;
import com.jsp.ecommerce.entity.Products;
import com.jsp.ecommerce.repo.ProductRepo;
import com.jsp.ecommerce.service.OrderService;
import com.jsp.ecommerce.service.ProductService;

@Controller
@RequestMapping("/ecommerce/order")
public class OrderController {
	@Autowired
	OrderService service;
	@Autowired
	ProductService prodservice;
	
	@GetMapping("/")
	public ResponseEntity<List<Order>>getAll() {
		return new ResponseEntity<List<Order>>(service.getAllOrder(),  HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/")
	public ResponseEntity<Order> save(@RequestBody Order order) {
		for (OrderItem item : order.getOrderItems()) {
            Products product = prodservice.getProdById(item.getProduct().getId());
            item.setProduct(product);
            item.setOrder(order);
            item.setPrice(product.getPrice());
        }

		return new ResponseEntity<>(service.insertOrder(order), HttpStatusCode.valueOf(201));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getByID(@PathVariable String id){
		return new ResponseEntity<Order>(service.getByData(id), HttpStatusCode.valueOf(200));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Order> deleteById(@PathVariable String id){
		service.deleteById(id);
		return new ResponseEntity<Order>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/")
	public ResponseEntity<Order> updateAll(@RequestBody Order order){
		for (OrderItem item : order.getOrderItems()) {
            Products product = prodservice.getProdById(item.getProduct().getId());
            item.setProduct(product);
            item.setOrder(order);
            item.setPrice(product.getPrice());
        }
		return new ResponseEntity<Order>(service.updateAll(order), HttpStatusCode.valueOf(200));
	}
	
	@PatchMapping("/{id}/{quantity}")
	public ResponseEntity<Order> updateCountById(@PathVariable String id, @PathVariable int count){
		return new ResponseEntity<Order>(service.updateByCount(id,count), HttpStatusCode.valueOf(200));
	}

}
