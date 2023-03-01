package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Category;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category addNewCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category updateCategoryDetails(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
