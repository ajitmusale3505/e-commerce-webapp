package com.jsp.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carts")
public class Cart {

	    @Id
	    @GeneratedValue(generator = "custom-id")
	    @GenericGenerator(
			name = "custom-id",
			strategy = "com.jsp.ecommerce.config.CartCustomId"
			)
	    private String id;

	    // One cart belongs to one user
	    @OneToOne
	    @JoinColumn(name = "user_id")
	    private Users user;
	    
	    // Cart contains multiple cart items
	    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	    private List<CartItem> cartItems = new ArrayList<>();
	    
	    public Cart() {
			// TODO Auto-generated constructor stub
		}
	    
	    
		public Cart(Users user, List<CartItem> cartItems) {
			this.user = user;
			this.cartItems = cartItems;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

		public List<CartItem> getCartItems() {
			return cartItems;
		}

		public void setCartItems(List<CartItem> cartItems) {
			this.cartItems = cartItems;
		}

		@Override
		public String toString() {
			return "Cart [id=" + id + ", user=" + user + ", cartItems=" + cartItems + "]";
		}
	    
	    
}
