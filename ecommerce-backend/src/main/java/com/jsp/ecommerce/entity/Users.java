package com.jsp.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Users {

	    @Id
	    @GeneratedValue(generator = "custom-id")
	    @GenericGenerator(
			name = "custom-id",
			strategy = "com.jsp.ecommerce.config.UserCustomId"
			)
    private String id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;  

    // One user has one cart
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    // One user can have multiple orders
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();
    
    
    public Users() {
		// TODO Auto-generated constructor stub
	}


	public Users(String name, String email, String password, String role, Cart cart, List<Order> orders) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.cart = cart;
		this.orders = orders;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", cart=" + cart + ", orders=" + orders + "]";
	}
    
    
}
