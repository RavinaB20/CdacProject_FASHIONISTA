package com.app.service;

import java.util.List;

import com.app.pojos.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();
	
	Category addNewCategory(Category category);
	
	String deleteCategory(Long categoryId);
	
	Category updateCategoryDetails(Category category);

}
