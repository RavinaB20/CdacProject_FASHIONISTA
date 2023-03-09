package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.CartItemDto;
import com.app.dto.ShoppingCartDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.ShoppingCart;
import com.app.pojos.User;
import com.app.repository.CartRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	public void createCartForUser(User user) {
		CartDto cartDto = new CartDto();
		cartDto.setUserId(user.getId());
		ShoppingCart c = modelMapper.map(cartDto, ShoppingCart.class);
		c.setUser(user);
		ShoppingCart shopingCart = cartRepo.save(c);	
	}
	
	public CartDto getCartByUserId(Long userId) {		
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User id is not correct"));
		ShoppingCart cart = cartRepo.findByUser(user);
		CartDto cartDto =  modelMapper.map(cart, CartDto.class);
		cartDto.setUserId(userId);
		return cartDto;
	}
	
	@Override
	public CartDto getCartById(Long id) {
		ShoppingCart cart = cartRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart not found with id "+id));		
		CartDto cartDto =  modelMapper.map(cart, CartDto.class);
		cartDto.setUserId(cart.getUser().getId());
		return cartDto;	
	}

    @Override
    public ApiResponse deleteCart(Long id) {
        ShoppingCart cart = cartRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id " + id));
        cartRepo.delete(cart);
        return new ApiResponse("Cart deleted");
    }


	@Override
	public ShoppingCartDto addCartItemToCart(Long cartId, CartItemDto cartItemDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItemFromCart(Long cartItemId) {
		// TODO Auto-generated method stub
		
	}
	
}
