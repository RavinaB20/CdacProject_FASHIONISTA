package com.app.pojos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/*
 * Product Entity : id, name,price,desc,inStock +
private Category productCategory;

 */
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	
	@Column(name = "product_name", length = 30, unique = true)
	@NotBlank(message = "Product name is required.")
	private String productName;
	
	private double price;

	private String description;
	
	@Column(name = "in_stock")
	private boolean inStock;
	
	private int quantity;
	
	private Color color;
	
	private int size;
	
	@Column(nullable = true, length = 500)
	private String productImagePath;
	
	// many to one Product *-----> 1Category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_category_id", nullable = false)
	private SubCategory productSubCategory;
		
	//Product 1----->1 CartItem

	public Product() {
		// TODO Auto-generated constructor stub
	}

 	public Product(String productName, double price, String description) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.inStock = true;
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

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public SubCategory getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(SubCategory productCategory) {
		this.productSubCategory = productCategory;
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

	@Override
	public String toString() {
		return "Product ID " + getId() + " [productName=" + productName + ", price=" + price + ", description="
				+ description + ", inStock=" + inStock + "]";
	}

	
	
}
