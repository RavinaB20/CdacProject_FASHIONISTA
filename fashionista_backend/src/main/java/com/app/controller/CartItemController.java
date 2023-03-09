package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddToCartRequest;
import com.app.dto.ApiResponse;
import com.app.dto.CartItemDto;
import com.app.dto.ProductCartItemDto;
import com.app.pojos.CartItem;
import com.app.service.CartItemService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/carts")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	
	@PostMapping("/{cartId}/add") //After clicking buy now
	public ResponseEntity<CartItemDto> addProductToCart(@PathVariable Long cartId, @RequestBody AddToCartRequest addToCartRequest) {
		CartItemDto cartItemDto = cartItemService.addProductToCart(addToCartRequest.getProductId(), addToCartRequest.getQuantity(), cartId);
		return ResponseEntity.ok(cartItemDto);
	}
	
	@DeleteMapping("/cart/{cartId}/cartItem/{cartItemId}")
	public ResponseEntity<?> deleteProductFromCart(@PathVariable Long cartId,@PathVariable Long cartItemId) {
		cartItemService.deleteProductFromCart(cartId, cartItemId);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{cartId}/items")
	public List<ProductCartItemDto> getAllCartItemsSpecificToCart(@PathVariable Long cartId){
		return cartItemService.getAllCartItemsSpecificToCart(cartId);
	}
}
