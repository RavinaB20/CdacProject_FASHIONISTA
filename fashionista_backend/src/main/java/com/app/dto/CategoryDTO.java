package com.app.dto;

import java.util.ArrayList;
import java.util.List;


import com.app.pojos.SubCategory;

public class CategoryDTO {

	private Long catId;
	
	private String categoryName;
	
	private String description;
	
	private List<SubCategoryDTO> subCategories = new ArrayList<>();

	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDTO(String categoryName, String description, List<SubCategoryDTO> subCategories) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.description = description;
		this.subCategories = subCategories;
	}

	public CategoryDTO(Long catId, String categoryName, String description, List<SubCategoryDTO> subCategories) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.description = description;
		this.subCategories = subCategories;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
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

	public List<SubCategoryDTO> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategoryDTO> subCategories) {
		this.subCategories = subCategories;
	}

	
	
}
