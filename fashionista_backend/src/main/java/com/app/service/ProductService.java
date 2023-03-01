package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface ProductService {
	List<Product> getAllProducts();
	
	Product addNewProduct(Long subCategoryId, Product product);
	
	String deleteSubCategory(Long categoryId);
	
	Product updateProductDetails(Product product);
}
