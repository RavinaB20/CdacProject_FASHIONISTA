package com.app.service;

import java.util.List;

import com.app.dto.SubCategoryDTO;
import com.app.pojos.SubCategory;

public interface SubCategoryService {
	
	List<SubCategoryDTO> getAllSubCategories();
	
	SubCategory addNewSubCategory(SubCategoryDTO subCategoryDto);
	
	String deleteSubCategory(Long categoryId);
	
	void updateSubCategoryDetails(Long id,SubCategoryDTO subCategoryDto);
	
//	List<SubCategory> getAllSubCategoryById(Long categoryId);
	
	SubCategoryDTO getSubCategoryById(Long id);
	
}
