package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dto.CategoryDTO;
import com.app.dto.ResponseGetCategoryDTO;
import com.app.dto.SubCategoryDTO;
import com.app.pojos.Category;
import com.app.pojos.SubCategory;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/*
	 * 	private SubCategoryDTO mapToDTO(SubCategory subCategory) {
		SubCategoryDTO subCategoryDTO = modelMapper.map(subCategory, SubCategoryDTO.class);
		subCategoryDTO.setProductCategoryId(subCategory.getProductCategory().getId());
		subCategoryDTO.setSubCatId(subCategory.getId());
		return subCategoryDTO;
	}

	 */

	private ResponseGetCategoryDTO mapToDTO(Category category) {
		ResponseGetCategoryDTO categoryDTO = modelMapper.map(category, ResponseGetCategoryDTO.class);
		categoryDTO.setCatId(category.getId());
		//categoryDTO.setSubCategories(category.getSubCategories().)
		return categoryDTO;
		
	}
	
	@Override
	public List<ResponseGetCategoryDTO> getAllCategories() {
		// TODO Auto-generated method stub
		//		return subCategories.stream().map(this::mapToDTO).collect(Collectors.toList());
		List<Category> categories = categoryRepo.findAll();
		System.out.println("CTEGORIES : "+categories);
		List<ResponseGetCategoryDTO> catDtoGet = categories.stream().map(this::mapToDTO).collect(Collectors.toList());  
		return catDtoGet;
	}

	@Override
	public Category addNewCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public String deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		String mesg = "delete category failed...";
		if(categoryRepo.existsById(categoryId))
		{
			categoryRepo.deleteById(categoryId);
			mesg = "User deleted successfully..";
		}
		return mesg;
	}

	@Override
	public Category updateCategoryDetails(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
