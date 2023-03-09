
package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Product;

public class SubCategoryDto {

	private Long subCatId;
	
	private String subCategoryName;
	
	private String description;
	
	private Long productCategoryId;
	
	private List<Product> products = new ArrayList<>();

	public SubCategoryDto() {
		// TODO Auto-generated constructor stub
		System.out.println("xxxxxxxx111111111111111111111111");
	}

	public SubCategoryDto(Long subCatId, String subCategoryName, String description, Long productCategoryId) {
		super();
		System.out.println("xxxxxxxxxx222222222222222222222222");
		this.subCatId = subCatId;
		this.subCategoryName = subCategoryName;
		this.description = description;
		this.productCategoryId = productCategoryId;
	}
	
	public SubCategoryDto(String subCategoryName, String description, Long productCategoryId, List<Product> products) {
		super();
		System.out.println("xxxxxxxxxxx3333333333333333333333333333333");
		this.subCategoryName = subCategoryName;
		this.description = description;
		this.productCategoryId = productCategoryId;
		this.products = products;
	}

	public SubCategoryDto(Long subCatId, String subCategoryName, String description, Long productCategoryId,
			List<Product> products) {
		super();
		System.out.println("xxxxxxxxx44444444444444444444444444444444");
		this.subCatId = subCatId;
		this.subCategoryName = subCategoryName;
		this.description = description;
		this.productCategoryId = productCategoryId;
		this.products = products;
	}

	public Long getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(Long subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProductCategoryId() {
		System.out.println("--------getProductCategoryId -----------");
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		System.out.println("setProductCategoryId------"+productCategoryId);
		this.productCategoryId = productCategoryId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
