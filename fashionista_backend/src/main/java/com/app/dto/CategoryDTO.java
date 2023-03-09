package com.app.dto;

import java.util.ArrayList;
import java.util.List;


import com.app.pojos.SubCategory;

public class CategoryDto {

	private Long catId;
	
	private String categoryName;
	
	private String description;
	
	private List<SubCategoryDto> subCategories = new ArrayList<>();

	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDto(String categoryName, String description, List<SubCategoryDto> subCategories) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.description = description;
		this.subCategories = subCategories;
	}

	public CategoryDto(Long catId, String categoryName, String description, List<SubCategoryDto> subCategories) {
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

	public List<SubCategoryDto> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategoryDto> subCategories) {
		this.subCategories = subCategories;
	}

	
	
}
