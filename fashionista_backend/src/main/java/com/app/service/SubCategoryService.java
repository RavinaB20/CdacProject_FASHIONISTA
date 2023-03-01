package com.app.service;

import java.util.List;

import com.app.pojos.SubCategory;

public interface SubCategoryService {
	List<SubCategory> getAllSubCategories();
	
	SubCategory addNewCategory(Long categoryId, SubCategory subCategory);
	
	String deleteSubCategory(Long categoryId);
	
	SubCategory updateSubCategoryDetails(SubCategory subCategory);
}
