package com.app.dto;

import java.util.List;

import com.app.pojos.ShoppingCart;

public class CartDto {
	
	private Long id;
	
	private List<CartItemDto> items;
	
	private double total;
	
	private Long userId;
	
	public CartDto() {
	}

	public CartDto(CartDto cartDto) {
		super();
		this.id = cartDto.getId();
		this.items = cartDto.getItems();
		this.total = cartDto.getTotal();
	}

	public CartDto(Long id, List<CartItemDto> items, double total) {
		super();
		this.id = id;
		this.items = items;
		this.total = total;
	}

	public CartDto(List<CartItemDto> items, double total) {
		super();
		this.items = items;
		this.total = total;
	}
	
	public CartDto(Long id, List<CartItemDto> items, double total, Long userId) {
		super();
		this.id = id;
		this.items = items;
		this.total = total;
		this.userId = userId;
	}

	public CartDto(ShoppingCart cart) {
		super();
		this.id = cart.getId();
		this.total = cart.getTotalCartPrice();
		this.userId = cart.getUser().getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<CartItemDto> getItems() {
		return items;
	}

	public void setItems(List<CartItemDto> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CartDto [id=" + id + ", items=" + items + ", total=" + total + ", userId=" + userId + "]";
	}
}
