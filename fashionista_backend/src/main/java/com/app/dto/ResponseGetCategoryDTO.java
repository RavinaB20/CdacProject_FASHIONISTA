package com.app.dto;

import java.util.ArrayList;
import java.util.List;


import com.app.pojos.SubCategory;

public class ResponseGetCategoryDTO {

	private Long catId;
	
	private String categoryName;
	
	private String description;
	
	public ResponseGetCategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseGetCategoryDTO(String categoryName, String description) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.description = description;
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
	
}
