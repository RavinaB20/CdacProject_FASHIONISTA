package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="cart_items")
public class CartItem extends BaseEntity {
	
	private int quantity;
	
	@Column(name="total_price")
	private double totalPrice;
	
	//CartItem *---->1 Cart
	@ManyToOne
	@JoinColumn(name="cart_id")
	private ShoppingCart cart;
	
	//CartItem 1--->1 Product
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product cartProduct;

	/*No need of this as other class order details is there.	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
*/	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	public CartItem(Product product, int quantity) {
		this.cartProduct = product;
		this.quantity = quantity;
	}
	
	public CartItem(int quantity, double totalPrice) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Product getCartProduct() {
		return cartProduct;
	}
	public void setCartProduct(Product cartProduct) {
		this.cartProduct = cartProduct;
	}
	
	@Override
	public String toString() {
		return "CartItem ID "+getId()+" [quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
