package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ResponseGetCategoryDto;
import com.app.pojos.Category;
import com.app.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/category")
@Validated
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	public CategoryController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/addCategory")
	public Category addNewCategory(@RequestBody @Valid Category newCategory) {
		System.out.println("In add category");
		return catService.addNewCategory(newCategory);
	}
	
	@GetMapping("/getCategories")
	public List<ResponseGetCategoryDto> getAllCategories(){
		System.out.println("In get all category");
		return catService.getAllCategories();
		//return new ResponseEntity<List<ResponseGetCategoryDTO>>(catService.getAllCategories(), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{categoryId}")
	public ApiResponse deleteCategory(@PathVariable Long categoryId) {
		return new ApiResponse(catService.deleteCategory(categoryId));
	}

}
