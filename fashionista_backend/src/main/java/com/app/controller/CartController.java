package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.service.ShoppingCartService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/carts")
public class CartController {
    
	@Autowired
    private ShoppingCartService cartService;
    
    @GetMapping("/{userId}")
    public CartDto getCartByUserId(@PathVariable Long userId) {
    	System.out.println("ID : "+userId);
        CartDto cartDto = cartService.getCartByUserId(userId);
        System.out.println("Cart dto : "+cartDto);
        return cartDto;
    }
    
    @GetMapping("/cart/{cartId}")
    public CartDto getCartByCartId(@PathVariable Long cartId) {
    	return cartService.getCartById(cartId);
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse deleteCart(@PathVariable Long id) {
    	return cartService.deleteCart(id);
    }
 
    /*    @PostMapping("/{userId}")
    public Cart createCart(@PathVariable Long userId, @RequestBody Cart cart) {
        return userRepository.findById(userId).map(user -> {
            cart.setUser(user);
            return cartRepository.save(cart);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }
*/
}