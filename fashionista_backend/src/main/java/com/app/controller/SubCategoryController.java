package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.SubCategoryDto;
import com.app.pojos.SubCategory;
import com.app.service.SubCategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/subCategory")
@Validated
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCatService;
	
	public SubCategoryController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/add")
	public ResponseEntity<SubCategory> addNewSubCategory(@RequestBody @Valid SubCategoryDto newSubCategoryDto) {
		System.out.println("In add sub category "+ newSubCategoryDto.getSubCategoryName());
		return new ResponseEntity<SubCategory>(subCatService.addNewSubCategory(newSubCategoryDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<SubCategoryDto> getAllSubCategories(){
		System.out.println("In get all category");
		return subCatService.getAllSubCategories();
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse deleteSubCategory(@PathVariable Long id) {
		return new ApiResponse(subCatService.deleteSubCategory(id));
	}

	@GetMapping("/getSubCategories/{categoryId}")
	public SubCategoryDto getSubCategoryById(@PathVariable Long categoryId) {
		return subCatService.getSubCategoryById(categoryId);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateSubCategoryDetails(@PathVariable Long id,@RequestBody SubCategoryDto subCategoryDto) {
		subCatService.updateSubCategoryDetails(id, subCategoryDto);
		return ResponseEntity.noContent().build();
	}
	
}
