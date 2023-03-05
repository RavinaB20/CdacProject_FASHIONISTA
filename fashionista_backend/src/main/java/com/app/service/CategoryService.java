package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.CategoryDTO;
import com.app.dto.ResponseGetCategoryDTO;
import com.app.pojos.Category;

public interface CategoryService {
	
	List<ResponseGetCategoryDTO> getAllCategories();
	
	Category addNewCategory(Category category);
	
	String deleteCategory(Long categoryId);
	
	Category updateCategoryDetails(Category category);

}
