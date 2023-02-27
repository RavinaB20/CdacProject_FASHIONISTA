package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
		// TODO Auto-generated constructor stub
	}
	
	public Category(String categoryName, String description, List<SubCategory> categories) {
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

	public List<SubCategory> getCategories() {
		return subCategories;
	}

	public void setCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", description=" + description + ", subCategories=" + subCategories
				+ "]";
	}
	
	public void addSubCategory(SubCategory cat) {
		subCategories.add(cat);
		cat.setProductCategory(this);
	}
	
	public void removeSubCategory(SubCategory cat) {
		subCategories.remove(cat);
		cat.setProductCategory(null);
	}
	
	

}
