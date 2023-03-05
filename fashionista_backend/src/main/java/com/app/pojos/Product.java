package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	
	@Column(name = "product_name", length = 30, unique = true)
	private String productName;
	
	private double price;

	@Column(length = 500)
	private String description;
		
	private int quantity;
	
	private Color color;
	
	private int size;
	
	@Column(nullable = true, length = 500)
	private String productImagePath;
	
	// many to one Product *-----> 1Category
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_category_id", nullable = false)
	@JsonIgnoreProperties("products")
	private SubCategory productSubCategory;
		
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, double price,
			String description, int quantity, Color color, int size, String productImagePath) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.color = color;
		this.size = size;
		this.productImagePath = productImagePath;
	}

	public Product(String productName, double price,
			String description, int quantity, Color color, int size, SubCategory productSubCategory) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.color = color;
		this.size = size;
		this.productSubCategory = productSubCategory;
	}

	public Product(String productName, double price,
			String description, int quantity, Color color, int size, String productImagePath,
			SubCategory productSubCategory) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.color = color;
		this.size = size;
		this.productImagePath = productImagePath;
		this.productSubCategory = productSubCategory;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public SubCategory getProductSubCategory() {
		System.out.println("prodsub cat : getterr : "+productSubCategory);
		
		return productSubCategory;
	}

	public void setProductSubCategory(SubCategory productSubCategory) {
		System.out.println("prodsub cat : SETTER : "+productSubCategory);

		this.productSubCategory = productSubCategory;
	}

	@Override
	public String toString() {
		return "PId : "+getId()+ " Product [productName=" + productName + ", price=" + price + ", description=" + description
				+ ", quantity=" + quantity + ", color=" + color + ", size=" + size + ", productImagePath="
				+ productImagePath +  "]";
	}

		
	
}
