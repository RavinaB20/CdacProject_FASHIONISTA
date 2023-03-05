package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
	
	@Column(name="category_name", length = 30, unique=true)
	private String categoryName;
	
	@Column(length = 300)
	private String description;
	
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubCategory> subCategories = new ArrayList<>();

	public Category() {
	}
	
	public Category(Long catId) {
		super();
		System.out.println("In category 1 arg ctor");
		this.setId(catId);
	}
	
	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	@Override
	public String toString() {
		return "category id : " +getId()+  "Category [categoryName=" + categoryName + ", description=" + description + ", subCategories=" + subCategories
				+ "]";
	}
	
	public void addSubCategory(SubCategory cat) {
		System.out.println("Addsub helper category............");
		subCategories.add(cat);
		cat.setProductCategory(this);
	}
	
	public void removeSubCategory(SubCategory cat) {
		subCategories.remove(cat);
		cat.setProductCategory(null);
	}
	
	

}
