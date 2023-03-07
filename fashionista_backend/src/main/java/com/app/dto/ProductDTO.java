package com.app.dto;

import com.app.pojos.Color;
import com.app.pojos.Product;

public class ProductDTO {
	
	private Long productId;
	
	private String productName;
	
	private double price;

	private String description;
		
	private int quantity;
	
	private Color color;
	
	private int size;
	
	private String productImagePath;
	
	private Long productSubCategoryId;

	public ProductDTO() {
		// TODO Auto-generated constructor stub
		System.out.println("In ctor proddto");
	}
	
	public ProductDTO(Product product) {
		super();
		System.out.println("Para 11111111111111111111111");
		this.productId = product.getId();
		this.productName = product.getProductName();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.quantity = product.getQuantity();
		this.color = product.getColor();
		this.size = product.getSize();
		this.productImagePath = product.getProductImagePath();
		this.productSubCategoryId = product.getProductSubCategory().getId();
	}
	
	public ProductDTO(Long productId, String productName, double price, String description, int quantity, Color color,
			int size, String productImagePath, Long productSubCategoryId) {
		super();
		System.out.println("Para 11111111111111111111111");
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.color = color;
		this.size = size;
		this.productImagePath = productImagePath;
		this.productSubCategoryId = productSubCategoryId;
	}

	public ProductDTO(String productName, double price, String description, int quantity, Color color, int size,
			String productImagePath, Long productSubCategoryId) {
		super();
		System.out.println("Para 2222222222222222222222222222222222");
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.color = color;
		this.size = size;
		this.productImagePath = productImagePath;
		this.productSubCategoryId = productSubCategoryId;
	}
	

	public ProductDTO(String productName, double price, String description, int quantity, Color color, int size,
			Long productSubCategoryId) {
		super();
		System.out.println("This ctor called in product dto : 3333333333333333333 : ");
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.color = color;
		this.size = size;
		this.productSubCategoryId = productSubCategoryId;
	}

	public Long getProductId() {
		System.out.println("In get prod id");
		return productId;
	}

	public void setProductId(Long productId) {
		System.out.println("In set prod id");

		this.productId = productId;
	}

	public String getProductName() {
		System.out.println("In get prod name"+productName);

		return productName;
	}

	public void setProductName(String productName) {
		System.out.println("In set prod name");

		this.productName = productName;
	}

	public double getPrice() {
		System.out.println("In get price");

		return price;
	}

	public void setPrice(double price) {
		System.out.println("In set price");

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

	public Long getProductSubCategoryId() {
		System.out.println("In get prod sub cate");
		return productSubCategoryId;
	}

	public void setProductSubCategoryId(Long productSubCategoryId) {
		System.out.println("In set peod sub cat : "+productSubCategoryId);
		this.productSubCategoryId = productSubCategoryId;
		System.out.println("AFTER  : "+productSubCategoryId);
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", description=" + description + ", quantity=" + quantity + ", color=" + color + ", size=" + size
				+ ", productImagePath=" + productImagePath + ", productSubCategoryId=" + productSubCategoryId + "]";
	}
	
	
}
