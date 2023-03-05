package com.app.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Product;
import com.app.pojos.SubCategory;
import java.util.List;
import com.app.pojos.Color;
import java.lang.String;

public interface ProductRepository extends JpaRepository<Product, Long>{

	//price, quantity, size, subCat

//	@Query(value = "select new com.app.pojos.Product from Product p where e.price between ?1 and ?2")
//	Stream<Product> fetchProductsByPriceRange(double minPrice, double maxPrice);

	List<Product> findByProductSubCategory(SubCategory productsubcategory);

	List<Product> findByColor(Color color);

	List<Product> findByProductName(String productname);
	
	List<Product> findByQuantity(int quantity);
	
	List<Product> findBySize(int size);
	
	
}
