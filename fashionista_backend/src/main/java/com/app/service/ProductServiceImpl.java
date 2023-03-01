package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addNewProduct(Long subCategoryId, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProductDetails(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
