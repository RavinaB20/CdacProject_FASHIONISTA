package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.SubCategory;
import com.app.repository.SubCategoryRepository;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	private SubCategoryRepository subCatRepo;

	@Override
	public List<SubCategory> getAllSubCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory addNewCategory(Long categoryId, SubCategory subCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory updateSubCategoryDetails(SubCategory subCategory) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
