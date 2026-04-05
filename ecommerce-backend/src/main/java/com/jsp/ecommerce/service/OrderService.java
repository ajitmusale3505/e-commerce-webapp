package com.jsp.ecommerce.service;

import java.util.List;

import com.jsp.ecommerce.entity.Order;

public interface OrderService {
	public Order insertOrder(Order Order);
	public List<Order> getAllOrder();
	public Order getByData(String id);
	public void deleteById(String id);
	public Order updateAll(Order cateogry);
    public Order updateByCount(String id, int count);
    
}
