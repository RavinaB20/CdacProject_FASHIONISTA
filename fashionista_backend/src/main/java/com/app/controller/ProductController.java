package com.app.controller;

import java.io.IOException;
import java.util.List;


import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;
import com.app.pojos.Color;
import com.app.pojos.Product;
import com.app.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products")
@Validated
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private ModelMapper modelMapper;

	public ProductController() {
	}
	
	@GetMapping
	public List<ProductDto> getAllProducts() {
		System.out.println("In get all product");
		return prodService.getAllProducts();
	}
	
	@PostMapping(value="/add", consumes = "multipart/form-data")
	public ResponseEntity<Product> addNewProduct(@RequestParam("productName") String productName,
											@RequestParam("price") double price,
											@RequestParam("description") String description,
											@RequestParam("quantity") int quantity,
											@RequestParam("color") Color color,
											@RequestParam("size") int size,
											@RequestParam("productSubCategoryId") Long subCatId,
											@RequestParam("file") MultipartFile file) throws IOException {
		ProductDto prodDto = new ProductDto();
		prodDto.setColor(color);
		prodDto.setDescription(description);
		prodDto.setPrice(price);
		prodDto.setProductName(productName);
		prodDto.setProductSubCategoryId(subCatId);
		prodDto.setQuantity(quantity);
		prodDto.setSize(size);	
		return new ResponseEntity<Product>(prodService.addNewProduct(prodDto, file), HttpStatus.CREATED);
	}

	// admin should be able to delete the products
	//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	
	@DeleteMapping("/{productId}")
	public ApiResponse deleteProducts(@PathVariable Long productId) {
		System.out.println("In delete product");
		return new ApiResponse(prodService.deleteProduct(productId));
	}
	
	@PutMapping("/{productId}")
	public ApiResponse updateProductDetails(@PathVariable Long productId, @RequestBody ProductDto productDto) {
		System.out.println("In update product");
		
		return new ApiResponse(prodService.updateProductDetails(productId, productDto));
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) {
		System.out.println("In product details");
		return ResponseEntity.ok(prodService.getProductById(productId));
	}
	
	@GetMapping("/sortProducts")
	public List<ProductDto> getSortedProducts(@RequestParam String sortBy, @RequestParam String order) {
	    return prodService.getSortedProducts(sortBy, order);
	    
	    //List<Product> products = productRepository.findAll(sortingOrder);
	    //return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	@GetMapping("/product/color")
	public List<ProductDto> getProductByColor(@RequestParam String color){
		return prodService.getProductByColor(Color.valueOf(color));
	}
	
	@GetMapping("/product/productName")
	public List<ProductDto> getProductByProductName(@RequestParam String productName){
		return prodService.getProductByProductName(productName);
	}
	
	@GetMapping("/product/quantity")
	public List<ProductDto> getProductByQuantity(@RequestParam int quantity){
		return prodService.getProductByQuantity(quantity);
	}
	
	@GetMapping("/product/size")
	public List<ProductDto> getProductBySize(@RequestParam int size){
		return prodService.getProductBySize(size);
	}
	
	@GetMapping("/product/subCatId")
	public List<ProductDto> getProductByCategoryId(@RequestParam Long subCatId){
		return prodService.getProductBySubCategory(subCatId);
	}
	
	
	
	// any authenticated user should be able to browse the categories
	@GetMapping("/browse_categories")
	public String browseCategories() {
		
		return "any authenticated user should be able to browse the categories";
	}

	// customer should be able to purchase products
	@GetMapping("/purchase")
	public String purchaseProducts() {
		return "customer should be able to purchase products";
	}
	
}
