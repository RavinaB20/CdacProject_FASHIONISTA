package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	@CreationTimestamp
	private LocalDate orderDate;
	
	private LocalDate deliveryDate;
	
	private double totalPrice;
	
	private double shippingFee;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Status orderStatus;
	// Order *----->1 Customer
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User customer;
	
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order",orphanRemoval = true)
	private List<OrderDetail> orderDetailList=new ArrayList<>();
	//helper methods
	public void addOrderDetail(OrderDetail detail)
	{
		orderDetailList.add(detail);//establishes parent(Order) --> child(OrderDetail)
		detail.setOrder(this);
	}
	
	public void removeOrderDetail(OrderDetail detail)
	{
		orderDetailList.remove(detail);//establishes parent(Order) --> child(OrderDetail)
		detail.setOrder(null);
	}
	


}
