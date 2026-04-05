package com.jsp.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ecommerce.entity.Order;
import com.jsp.ecommerce.entity.OrderItem;
import com.jsp.ecommerce.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo repo;

	@Override
	public Order insertOrder(Order order) {
		return repo.save(order);
	}

	@Override
	public List<Order> getAllOrder() {
		return repo.findAll();
	}

	@Override
	public Order getByData(String id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteById(String id) {
		 repo.deleteById(id);
	}

	@Override
	public Order updateAll(Order order) {
		return repo.save(order);
	}

	@Override
	public Order updateByCount(String id, int count) {
		   Order order = repo.findById(id).get();
		    for (OrderItem item : order.getOrderItems()) {
		        item.setQuantity(count); 
		    }

		    // 3. Save updated order
		    return repo.save(order);
	}
	 
}
