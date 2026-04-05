package com.jsp.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "orders") 
public class Order {
	    @Id
	    @GeneratedValue(generator = "custom-id")
	    @GenericGenerator(
			name = "custom-id",
			strategy = "com.jsp.ecommerce.config.OderCustomId"
			)
    private String id;

    private LocalDateTime orderDate;

    private Double totalAmount;

    private String status; // PENDING, SHIPPED, DELIVERED

    // Many orders belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    // Order contains multiple order items
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderItem> orderItems = new ArrayList<>();
    
    
    public Order() {
		// TODO Auto-generated constructor stub
	}


	public Order(LocalDateTime orderDate, Double totalAmount, String status, Users user,
			List<OrderItem> orderItems) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.user = user;
		this.orderItems = orderItems;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status
				+ ", user=" + user + ", orderItems=" + orderItems + "]";
	}
    
    
}
