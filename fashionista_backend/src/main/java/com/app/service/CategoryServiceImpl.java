package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dto.CategoryDto;
import com.app.dto.ResponseGetCategoryDto;
import com.app.dto.SubCategoryDto;
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

	private ResponseGetCategoryDto mapToDTO(Category category) {
		ResponseGetCategoryDto categoryDTO = modelMapper.map(category, ResponseGetCategoryDto.class);
		categoryDTO.setCatId(category.getId());
		//categoryDTO.setSubCategories(category.getSubCategories().)
		return categoryDTO;
		
	}
	
	@Override
	public List<ResponseGetCategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		//		return subCategories.stream().map(this::mapToDTO).collect(Collectors.toList());
		List<Category> categories = categoryRepo.findAll();
		System.out.println("CTEGORIES : "+categories);
		List<ResponseGetCategoryDto> catDtoGet = categories.stream().map(this::mapToDTO).collect(Collectors.toList());  
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
