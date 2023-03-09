package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Color;
import com.app.pojos.Product;
import com.app.pojos.SubCategory;
import com.app.repository.ProductRepository;
import com.app.repository.SubCategoryRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private SubCategoryRepository subCatRepo;
	
	@Value("${content.upload.folder}")
	private String folderName;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init "+modelMapper);
		File path = new File(folderName);
		if (!path.exists()) {
			path.mkdirs();
		} else
			System.out.println("folder alrdy exists....");
	}

	private ProductDto mapToDTO(Product product) {
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		productDto.setProductSubCategoryId(product.getProductSubCategory().getId());
		productDto.setProductId(product.getId());
		return productDto;
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public Product addNewProduct(ProductDto prodDto ,MultipartFile file) throws IOException {
		
		Product product = new Product();
		product.setProductName(prodDto.getProductName());
		product.setDescription(prodDto.getDescription());
		product.setColor(prodDto.getColor());
		product.setPrice(prodDto.getPrice());
		product.setQuantity(prodDto.getQuantity());
		product.setSize(prodDto.getSize());
		
		SubCategory subCategory = subCatRepo.findById(prodDto.getProductSubCategoryId()).orElseThrow(()->new ResourceNotFoundException("Wrong category id"));
		product.setProductSubCategory(subCategory);
		
		String targetPath = folderName + File.separator + file.getOriginalFilename();
		System.out.println(targetPath);
	  	Files.copy(file.getInputStream(), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
	 	
	  	product.setProductImagePath(targetPath);
	  	return productRepo.save(product);
	}

	private String saveImage(MultipartFile file)throws IOException{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	  	Path path = Paths.get("images/"+fileName);
	  	Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	  	return path.toString();
	}

	@Override
	public String deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		if(productRepo.existsById(productId)) {
			productRepo.deleteById(productId);
			return "Product details deleted ...";
		}
		return "Deletion failed : Invalid Product Id !!!!";
	}

	@Override
	public String updateProductDetails(Long productId, ProductDto productDto) {
		Product prod = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		if(productDto.getProductSubCategoryId()!=prod.getProductSubCategory().getId())
		{
			SubCategory subCategory = subCatRepo.findById(productDto.getProductSubCategoryId()).orElseThrow(()-> new ResourceNotFoundException("Sub category not found"));
			prod.setProductSubCategory(subCategory);
		}
		if(productDto.getColor()!=prod.getColor())
			prod.setColor(productDto.getColor());
		if(productDto.getDescription()!=prod.getDescription())
			prod.setDescription(productDto.getDescription());
		if(productDto.getPrice()!=prod.getPrice())
			prod.setPrice(productDto.getPrice());
		if(productDto.getProductName()!=prod.getProductName())
			prod.setProductName(productDto.getProductName());
		if(productDto.getQuantity()!=prod.getQuantity())
			prod.setQuantity(productDto.getQuantity());
		if(productDto.getSize()!=prod.getSize())
			prod.setSize(productDto.getSize());
		productRepo.save(prod);
		return "Product updated successfully";
	}

	@Override
	public ProductDto getProductById(Long productId) {
		
		return productRepo.findById(productId).map(this::mapToDTO).orElseThrow(() -> new ResourceNotFoundException("Invalid product Id.."));
		
	}

	@Override
	public List<ProductDto> getSortedProducts(String sortBy, String order) {
		// TODO Auto-generated method stub
	    Sort sortingOrder = order.equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		List<Product> products = productRepo.findAll(sortingOrder);
		return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}

	public List<ProductDto> getProductByColor(Color color){
		return productRepo.findByColor(color).stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	public List<ProductDto> getProductByProductName(String productName){
		return productRepo.findByProductName(productName).stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	public List<ProductDto> getProductBySubCategory(Long subCatId){
		
		SubCategory subCategory = subCatRepo.findById(subCatId).orElseThrow(()->new ResourceNotFoundException("Subcategory is invalid."));
		return productRepo.findByProductSubCategory(subCategory) .stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	public List<ProductDto> getProductByQuantity(int quantity){
		return productRepo.findByQuantity(quantity).stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	public List<ProductDto> getProductBySize(int size){
		return productRepo.findBySize(size).stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	
	
}
