package com.app.dto;

import com.app.pojos.CartItem;

public class CartItemDto {
	
	private Long id;
	
	private Long productId;
	
	private Integer quantity;
	
	public CartItemDto() {
	}

	public CartItemDto(CartItem cartItem) {
		super();
		this.id = cartItem.getId();
		this.productId = cartItem.getCartProduct().getId();
		this.quantity = cartItem.getQuantity();
	}
	
	public CartItemDto(Long id, Long productId, Integer quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	public CartItemDto(Long productId, Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
