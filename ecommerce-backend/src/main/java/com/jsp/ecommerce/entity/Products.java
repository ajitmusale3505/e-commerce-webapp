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
public class Products {
	    @Id
	    @GeneratedValue(generator = "custom-id")
	    @GenericGenerator(
			name = "custom-id",
			strategy = "com.jsp.ecommerce.config.ProdCustomID"
			)
	    private String id;

	    private String name;

	    private String description;

	    private Double price;

	    private Integer stock;

	    private String imageUrl;

	    // Many products belong to one category
	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;
	    
	    public Products() {
			// TODO Auto-generated constructor stub
		}

		public Products(String name, String description, Double price, Integer stock, String imageUrl,
				Category category) {
			super();
			 
			this.name = name;
			this.description = description;
			this.price = price;
			this.stock = stock;
			this.imageUrl = imageUrl;
			this.category = category;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "Products [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
					+ ", stock=" + stock + ", imageUrl=" + imageUrl + ", category=" + category + "]";
		}
	    
	    
}
