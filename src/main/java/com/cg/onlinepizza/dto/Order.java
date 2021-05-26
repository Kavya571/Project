package com.cg.onlinepizza.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Orders")
public class Order {
	@Id
	private int orderId;
	private String orderType;
	private String orderDesc;
	
	private int customerId;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="bookingOrderId")
//	private PizzaOrder pizzaorder;

	@OneToOne(cascade= CascadeType.ALL)
	private PizzaOrder pizzaorder;
	
	public Order() {
		super();
	}

	public Order(int orderId, String orderType, String orderDesc, int customerId) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.orderDesc = orderDesc;
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public PizzaOrder getPizzaorder() {
		return pizzaorder;
	}

	public void setPizzaorder(PizzaOrder pizzaorder) {
		this.pizzaorder = pizzaorder;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	
}




