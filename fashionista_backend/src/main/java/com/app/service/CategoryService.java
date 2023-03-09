package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.CategoryDto;
import com.app.dto.ResponseGetCategoryDto;
import com.app.pojos.Category;

public interface CategoryService {
	
	List<ResponseGetCategoryDto> getAllCategories();
	
	Category addNewCategory(Category category);
	
	String deleteCategory(Long categoryId);
	
	Category updateCategoryDetails(Category category);

}
