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
@Getter
@Setter
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
