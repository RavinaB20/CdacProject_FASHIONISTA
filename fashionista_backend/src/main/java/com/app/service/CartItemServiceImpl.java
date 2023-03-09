package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.dto.ApiResponse;
import com.app.dto.CartItemDto;
import com.app.dto.ProductCartItemDto;
import com.app.dto.ProductDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.CartItem;
import com.app.pojos.Product;
import com.app.pojos.ShoppingCart;
import com.app.repository.CartItemRepository;
import com.app.repository.CartRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CartItemDto addProductToCart( Long productId, int quantity, Long cartId) {
		ShoppingCart cart = cartRepo.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("Shoping cart not found"));
		Product product = prodRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product not found"));
		
		CartItem existingCartItem = cartItemRepo.findByCartProductAndCart(product, cart);
		if(existingCartItem != null) {
			existingCartItem.setQuantity(existingCartItem.getQuantity()+quantity);
			existingCartItem.setTotalPrice(existingCartItem.getQuantity()*product.getPrice());
			existingCartItem = cartItemRepo.save(existingCartItem);
			return modelMapper.map(existingCartItem, CartItemDto.class);
		}
		else {
			CartItem cartItem = new CartItem(product, quantity);
			cartItem.setCart(cart);
			cartItem.setCartProduct(product);
			cartItem.setQuantity(quantity);
			cartItem.setTotalPrice(quantity*product.getPrice());
			cartItem = cartItemRepo.save(cartItem);
			return modelMapper.map(cartItem, CartItemDto.class);
		}
	}
	
	@Override
	public void deleteProductFromCart(Long cartId, Long cartItemId) {
		ShoppingCart cart = cartRepo.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("Shoping cart not found"));
		CartItem cartItem = cartItemRepo.findById(cartItemId).orElseThrow(()-> new ResourceNotFoundException("Cart item not found"));
		cart.removeCartItem(cartItem);
		cartRepo.save(cart);
	}
	
	@Override
	public List<ProductCartItemDto> getAllCartItemsSpecificToCart(Long cartId){

		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		ShoppingCart cart = cartRepo.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("Cart not found"));
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
		List<CartItem> cartItems = cartItemRepo.findByCart(cart);
		System.out.println("111111111cart items : "+cartItems);

		
		List<ProductCartItemDto> cartItemDtos = new ArrayList<ProductCartItemDto>();
		for(CartItem cartItem : cartItems) {
			System.out.println("cartItem : "+cartItem);
			ProductCartItemDto cartItemDto = new ProductCartItemDto(cartItem);
			
			System.out.println("cart inside : "+cartItemDto);
			cartItemDtos.add(cartItemDto);
		}
		System.out.println("cartItemdetos : "+cartItemDtos);
		
		//cartItems.stream().map(ProductCartItemDto::new).collect(Collectors.toList());
		//		return products.stream().map(ProductDto::new).collect(Collectors.toList());
		/*
		 * cartItemDto.stream().forEach(item->{
		 * item.setProduct(prodRepo.findById(item.getProduct().getId()).orElseThrow(()->
		 * new ResourceNotFoundException("Product not found"))); });
		 */
		
		/*
		 * cartItems.stream().forEach(item -> {
		 * System.out.println("aa : "+item.getCartProduct().getProductName());
		 * item.setCartProduct(item.getCartProduct()); });
		 */
		
		return cartItemDtos;
	}
	
/*	@Override
	public List<CartItemDto> getAllCartItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemDto getCartItemById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	   @Override
	    public ProductCartItemDto addCartItem(CartItemRequestDto cartItemRequestDto, Long cartId) {
	        ShoppingCart shoppingCart = new ShoppingCart(cartId);
	        ProductDto productDto = productService.getProductById(cartItemRequestDto.getProductId());// cartItemRequestDto.getProductId());
	        int quantity = cartItemRequestDto.getQuantity();
	        Product prod = modelMapper.map(productDto, Product.class);

	        CartItem existingCartItem = cartItemRepo.findByCartProductAndCart(prod, shoppingCart);
	        if (existingCartItem != null) {
	            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
	            cartItemRepo.save(existingCartItem);
	            return modelMapper.map(existingCartItem, ProductCartItemDto.class);
	        }

	        CartItem cartItem = new CartItem(prod, quantity);
	        cartItem.setCart(shoppingCart);
	        cartItemRepo.save(cartItem);
	        return modelMapper.map(cartItem, ProductCartItemDto.class);
	    }
	   
/*	   public ProductCartItemDto getCartItem(Long id, Long cartId) {
		    Optional<CartItem> cartItemOptional = cartItemRepo.find findByIdAndShoppingCartId(id, cartId);
		    if (cartItemOptional.isEmpty()) {
		        throw new NotFoundException("CartItem not found");
		    }

		    CartItem cartItem = cartItemOptional.get();
		    Product product = cartItem.getProduct();
		    Integer quantity = cartItem.getQuantity();

		    ProductCartItemDto productCartItemDto = new ProductCartItemDto();
		    productCartItemDto.setId(cartItem.getId());
		    productCartItemDto.setProductId(product.getId());
		    productCartItemDto.setProductName(product.getName());
		    productCartItemDto.setProductPrice(product.getPrice());
		    productCartItemDto.setQuantity(quantity);

		    return productCartItemDto;
		}
*/

/*	@Override
	public void deleteCartItem(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public CartItemDto updateCartItemQuantity(Long cartItemId, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(Long cartItemId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ProductCartItemDto getCartItem(Long id, Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
