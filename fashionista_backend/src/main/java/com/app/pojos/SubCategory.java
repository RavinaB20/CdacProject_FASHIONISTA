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

@Entity
@Table(name="sub_categories")
public class SubCategory extends BaseEntity {
	@Column(name="sub_category_name",length = 30,unique = true)
	private String subCategoryName;
	
	@Column(length = 300)
	private String description;
	
	// one to many : bi dir Category 1--->* Product
	//Category -- one , parent ,non-owning, inverse(since no FK mapping)
	@OneToMany(mappedBy = "productSubCategory", cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<Product> products = new ArrayList<>();// init to empty list //as per Gavin King's suggestion : DO NOT keep collection based null

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category productCategory;
	
	
	
	public SubCategory() {
		// TODO Auto-generated constructor stub
	}

	public SubCategory(String categoryName, String description) {
		super();
		this.subCategoryName = categoryName;
		this.description = description;
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
		this.productCategory = productCategory;
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
	// Founder's suggestion : NEVER add asso properties toString --o.w may cause
	// recursion!

	@Override
	public String toString() {
		return "Category ID " + getId() + " [categoryName=" + subCategoryName + ", description=" + description + "]";
	}
	//add a method(convenience/helper) to establish a bi dir asso. between entities
	public void addProduct(Product p)
	{
		//parent --> child
		products.add(p);
		//child --> parent
		p.setProductSubCategory(this);
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
