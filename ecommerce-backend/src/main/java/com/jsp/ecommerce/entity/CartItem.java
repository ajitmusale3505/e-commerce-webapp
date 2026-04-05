package com.jsp.ecommerce.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CartItems")
public class CartItem {
	 @Id
	    @GeneratedValue(generator = "custom-id")
	    @GenericGenerator(
			name = "custom-id",
			strategy = "com.jsp.ecommerce.config.CartItemCustomID"
			)
	    private String id;

	    private Integer quantity;

	    // Many cart items belong to one cart
	    @ManyToOne
	    @JoinColumn(name = "cart_id")
	    private Cart cart;

	    // Each item refers to one product
	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Products product;
	    
	    public CartItem() {
			// TODO Auto-generated constructor stub
		}
	    
	    

		public CartItem(int quantity, Cart cart, Products product) {
			super();
			this.quantity = quantity;
			this.cart = cart;
			this.product = product;
		}



		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Products getProduct() {
			return product;
		}

		public void setProduct(Products product) {
			this.product = product;
		}

		@Override
		public String toString() {
			return "CartItem [id=" + id + ", quantity=" + quantity + ", cart=" + cart + ", product=" + product + "]";
		}
	    
	    
}

