package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sub_categories")
public class SubCategory extends BaseEntity {
	@Column(name="sub_category_name",length = 30,unique = true)
	private String subCategoryName;
	
	@Column(length = 300)
	private String description;
	
	@OneToMany(mappedBy = "productSubCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("subCategories")
	private Category productCategory;
	
	public SubCategory() {
		// TODO Auto-generated constructor stub
	}

	public SubCategory(String categoryName, String description) {
		super();
		System.out.println("In sub cat ctor...");
		this.subCategoryName = categoryName;
		this.description = description;
	}

	

	public SubCategory(String subCategoryName, String description, Category productCategory) {
		super();
		this.subCategoryName = subCategoryName;
		this.description = description;
		this.productCategory = productCategory;
	}

	public SubCategory(String subCategoryName, String description, List<Product> products, Category productCategory) {
		super();
		this.subCategoryName = subCategoryName;
		this.description = description;
		this.products = products;
		this.productCategory = productCategory;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		System.out.println("In setter set product category" + productCategory);		
		this.productCategory = productCategory;
		System.out.println("After setting id : - " +productCategory);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	//add a method(convenience/helper) to establish a bi dir asso. between entities
	public void addProduct(Product p)
	{
		//parent --> child
		products.add(p);
		//child --> parent
		p.setProductSubCategory(this);
	}
	@Override
	public String toString() {
		return "SubCategory "+getId()+" [subCategoryName=" + subCategoryName + ", description=" + description + ", products="
				+ products +"]";
	}

	//add a method(convenience/helper) to remove a bi dir asso. between entities
	public void removeProduct(Product p)
	{
		//parent ----X---> child
		products.remove(p);
		//child ----X----> parent
		p.setProductSubCategory(null);
		
		
	}

}
