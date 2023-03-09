package com.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.app.dto.ApiResponse;
import com.app.dto.CartItemDto;
import com.app.dto.ProductCartItemDto;
import com.app.pojos.CartItem;


public interface CartItemService {
	
//    List<CartItemDto> getAllCartItems();
    
//    CartItemDto getCartItemById(Long id);
    
    
//    void deleteCartItem(Long id);
    
    CartItemDto addProductToCart(Long productId, int quantity, Long cartId);
    void deleteProductFromCart(Long cartId, Long cartItemId);
	List<ProductCartItemDto> getAllCartItemsSpecificToCart(Long cartId);

    
//    CartItemDto updateCartItemQuantity(Long cartItemId, int quantity);
//    void removeCartItem(Long cartItemId);

//	ProductCartItemDto addCartItem(CartItemRequestDto cartItemRequestDto, Long cartId);
//	ProductCartItemDto getCartItem(Long id, Long cartId);

    
}
