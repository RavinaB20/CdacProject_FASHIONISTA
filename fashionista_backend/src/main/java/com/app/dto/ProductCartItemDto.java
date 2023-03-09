package com.app.dto;

import com.app.pojos.CartItem;

public class ProductCartItemDto {
    private Long id;
    private ProductDto product;
    private int quantity;

    public ProductCartItemDto() {
		// TODO Auto-generated constructor stub
	}
    
    public ProductCartItemDto(CartItem cartItem) {
		super();
		this.id = cartItem.getId();
		this.product = new ProductDto();
	    if (cartItem.getCartProduct() != null) {
	        this.product.setProductId(cartItem.getCartProduct().getId());
	        this.product.setColor(cartItem.getCartProduct().getColor());
	        this.product.setDescription(cartItem.getCartProduct().getDescription());
	        this.product.setPrice(cartItem.getCartProduct().getPrice());
	        this.product.setProductImagePath(cartItem.getCartProduct().getProductImagePath());
	        this.product.setProductName(cartItem.getCartProduct().getProductName());
	        this.product.setProductSubCategoryId(cartItem.getCartProduct().getProductSubCategory().getId());
	        this.product.setQuantity(cartItem.getCartProduct().getQuantity());
	        this.product.setSize(cartItem.getCartProduct().getSize());
	    }
		this.quantity = cartItem.getQuantity();
	}
        
    public ProductCartItemDto(Long id, ProductDto product, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
