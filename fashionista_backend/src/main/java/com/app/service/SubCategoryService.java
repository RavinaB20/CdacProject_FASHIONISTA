package com.app.service;

import java.util.List;

import com.app.dto.SubCategoryDto;
import com.app.pojos.SubCategory;

public interface SubCategoryService {
	
	List<SubCategoryDto> getAllSubCategories();
	
	SubCategory addNewSubCategory(SubCategoryDto subCategoryDto);
	
	String deleteSubCategory(Long categoryId);
	
	void updateSubCategoryDetails(Long id,SubCategoryDto subCategoryDto);
	
//	List<SubCategory> getAllSubCategoryById(Long categoryId);
	
	SubCategoryDto getSubCategoryById(Long id);
	
}
