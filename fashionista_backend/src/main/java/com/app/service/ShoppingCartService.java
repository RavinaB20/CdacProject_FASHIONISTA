package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.CartItemDto;
import com.app.dto.ShoppingCartDto;
import com.app.pojos.User;

public interface ShoppingCartService {

	void createCartForUser(User user);
	
	CartDto getCartByUserId(Long userId);

	CartDto getCartById(Long id);

    ApiResponse deleteCart(Long id);
    
    ShoppingCartDto addCartItemToCart(Long cartId, CartItemDto cartItemDTO);
    
    void removeCartItemFromCart(Long cartItemId);
    
    //  CartDto createCart(Long userId, CartDto cartDTO);
    
}
