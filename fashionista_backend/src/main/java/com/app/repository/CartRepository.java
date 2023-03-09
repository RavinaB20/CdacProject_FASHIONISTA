package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CartItem;
import com.app.pojos.ShoppingCart;
import com.app.pojos.User;
import java.util.List;

public interface CartRepository extends JpaRepository<ShoppingCart, Long>{
	//Optional<ShoppingCart> findByUser(Long userId);
	
	ShoppingCart findByUser(User user);

}
