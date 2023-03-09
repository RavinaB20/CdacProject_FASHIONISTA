package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.CartItem;
import com.app.pojos.Product;
import com.app.pojos.ShoppingCart;

import java.util.Optional;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	CartItem findByCartProductAndCart(Product cartproduct, ShoppingCart cart);

	List<CartItem> findByCart(ShoppingCart cart);
}
