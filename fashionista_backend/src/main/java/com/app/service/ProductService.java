package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;
import com.app.pojos.Color;
import com.app.pojos.Product;

public interface ProductService {
	
	Product addNewProduct(ProductDto prodDto, MultipartFile file) throws IOException;
	
	List<ProductDto> getAllProducts();	
	
	String deleteProduct(Long productId);
	
	String updateProductDetails(Long productId, ProductDto productDto);
	
	ProductDto getProductById(Long productId);
	
	List<ProductDto> getSortedProducts(String sortBy, String order);
	
	List<ProductDto> getProductByColor(Color color);

	List<ProductDto> getProductByProductName(String productName);

	List<ProductDto> getProductBySubCategory(Long subCatId);

	List<ProductDto> getProductByQuantity(int quantity);

	List<ProductDto> getProductBySize(int size);
	
	//price, quantity, size, subCat

}
