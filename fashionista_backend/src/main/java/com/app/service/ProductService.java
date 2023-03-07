package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.pojos.Color;
import com.app.pojos.Product;

public interface ProductService {
	
	Product addNewProduct(ProductDTO prodDto, MultipartFile file) throws IOException;
	
	List<ProductDTO> getAllProducts();	
	
	String deleteProduct(Long productId);
	
	String updateProductDetails(Long productId, ProductDTO productDto);
	
	ProductDTO getProductById(Long productId);
	
	List<ProductDTO> getSortedProducts(String sortBy, String order);
	
	List<ProductDTO> getProductByColor(Color color);

	List<ProductDTO> getProductByProductName(String productName);

	List<ProductDTO> getProductBySubCategory(Long subCatId);

	List<ProductDTO> getProductByQuantity(int quantity);

	List<ProductDTO> getProductBySize(int size);
	
	//price, quantity, size, subCat

}
