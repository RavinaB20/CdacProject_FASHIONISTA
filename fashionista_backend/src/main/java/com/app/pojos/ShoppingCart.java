package com.app.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "carts")
public class ShoppingCart extends BaseEntity {
	@Column(name = "total_items")
	private int totalItems;

	@Column(name = "total_cart_price")
	private double totalCartPrice;
	
	@Column(name = "created_on")
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	// Cart 1--->1 User	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") // to specify FK col name
	private User user;
	
	// Cart 1<----->* CartItem
	//cart : one , parent , inverse
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> cartItems = new ArrayList<>();
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingCart(Long cartId) {
		// TODO Auto-generated constructor stub
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public double getTotalCartPrice() {
		return totalCartPrice;
	}

	public void setTotalCartPrice(double totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	//Helper methods : linking n de linking
	public void addCartItem(CartItem item)
	{
		cartItems.add(item);
		item.setCart(this);
	}
	
	public void removeCartItem(CartItem item)
	{
		cartItems.remove(item);
		item.setCart(null);
	}
	
	@Override
	public String toString() {
		return "ShoppingCart"+getId()+" [totalItems=" + totalItems + ", totalCartPrice=" + totalCartPrice + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn +"]";
	}

	/*
	 * @Override public String toString() { return "ShoppingCart [totalItems=" +
	 * totalItems + ", totalCartPrice=" + totalCartPrice + ", createdOn=" +
	 * createdOn + ", updatedOn=" + updatedOn + "]"; }
	 */
	
	
}
