package com.jsp.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {

	    @Id
        @GeneratedValue(generator = "custom-id")
        @GenericGenerator(
		name = "custom-id",
		strategy = "com.jsp.ecommerce.config.CategoryCustomId"
		)
	    private String id;

	    private String name;

	    private String description;

	    // One category has many products
	    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	    private List<Products> products = new ArrayList<>();
	    
	    public Category() {
			// TODO Auto-generated constructor stub
		}

		public Category(String name, String description, List<Products> products) {
			super();
			this.name = name;
			this.description = description;
			this.products = products;
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

		public List<Products> getProducts() {
			return products;
		}

		public void setProducts(List<Products> products) {
			this.products = products;
		}

		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + ", description=" + description + ", products=" + products
					+ "]";
		}
	    
	    
}
