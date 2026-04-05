package com.jsp.ecommerce.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class OrderItem {
	    @Id
	    @GeneratedValue(generator = "custom-id")
	    @GenericGenerator(
			name = "custom-id",
			strategy = "com.jsp.ecommerce.config.OrderItemCustomId"
			)
    private String id;

    private Integer quantity;

    private Double price;

    // Many order items belong to one order
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    // Each item refers to one product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
    
    public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem( Integer quantity, Double price, Order order, Products product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", order=" + order + ", product="
				+ product + "]";
	}
    
    
}
