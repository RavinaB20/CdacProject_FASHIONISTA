package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.SubCategoryDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Category;
import com.app.pojos.SubCategory;
import com.app.repository.CategoryRepository;
import com.app.repository.SubCategoryRepository;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SubCategoryRepository subCatRepo;

	@Autowired
	private CategoryRepository catRepo;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init "+modelMapper);
	}
	
	@Override
	public List<SubCategoryDto> getAllSubCategories() {
		// TODO Auto-generated method stub
		//return subCatRepo.findAll();
		List<SubCategory> subCategories = subCatRepo.findAll();
		System.out.println("SUb cats : "+subCategories);
		
		
		//return modelMapper.map(subCategories, SubCategoryDTO.class);
		return subCategories.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	private SubCategoryDto mapToDTO(SubCategory subCategory) {
		SubCategoryDto subCategoryDTO = modelMapper.map(subCategory, SubCategoryDto.class);
		subCategoryDTO.setProductCategoryId(subCategory.getProductCategory().getId());
		subCategoryDTO.setSubCatId(subCategory.getId());
		return subCategoryDTO;
	}
	
	@Override
	public SubCategory addNewSubCategory(SubCategoryDto subCategoryDto) {
		// TODO Auto-generated method stub
		Category category = catRepo.findById(subCategoryDto.getProductCategoryId()).orElseThrow(()-> new EntityNotFoundException("Category Not found" ));		
		SubCategory subCategory = new SubCategory(subCategoryDto.getSubCategoryName(), subCategoryDto.getDescription(), category);
		System.out.println("In service add new category");
		return subCatRepo.save(subCategory);
	}
		
		
		
	/*
	 * String mesg = "Category is wrong";
	 * 
	 * 
	 * Long catId = subCategory.getId();
	 * 
	 * System.out.println("Cat is - "+catId);
	 * 
	 * if(catRepo.existsById(catId)) {
	 * System.out.println("Here inside..............."); mesg =
	 * "Sub category added succesfully..."; }
	 * System.out.println("Out of if stmt...."); return mesg; }
	 */
	@Override
	public String deleteSubCategory(Long subCategoryId) {
		// TODO Auto-generated method stub
		String mesg = "failed to delete sub category";
		if(subCatRepo.existsById(subCategoryId))
		{
			subCatRepo.deleteById(subCategoryId);
			mesg = "Subcategory deleted successfully..";
		}
		return mesg;
	}

	@Override
	public SubCategoryDto getSubCategoryById(Long id) {
		System.out.println("here id : "+id);
        SubCategory subCategory = subCatRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Subcategory not found"));
		System.out.println("Print subcat : "+subCategory);
        
        return mapToDTO(subCategory);
        /*
		 * SubCategoryDTO subCategoryDTO = null; if (subCategory.isPresent()) {
		 * subCategoryDTO = mapToDTO(subCategory.get()); } throw new
		 * ResourceNotFoundException("Sub category not exists");
		 */	}
	
	@Override
	public void updateSubCategoryDetails(Long id, SubCategoryDto subCategoryDto) {
		// TODO Auto-generated method stub
		SubCategory subCategory = subCatRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Subcategory not found"));
		if(subCategoryDto.getDescription() != null)
			subCategory.setDescription(subCategoryDto.getDescription());
		if(subCategoryDto.getSubCategoryName() != null)
			subCategory.setSubCategoryName(subCategoryDto.getSubCategoryName());
		subCatRepo.save(subCategory);
	}

	/*
	 * @Override public List<SubCategory> getAllSubCategoryById(Long categoryId) {
	 * // TODO Auto-generated method stub Category category =
	 * catRepo.findById(categoryId).orElseThrow(()-> new
	 * ResourceNotFoundException("Category not found")); List<SubCategory>
	 * subCategories = category.getSubCategories(); return subCategories; }
	 * 
	 */	
}
