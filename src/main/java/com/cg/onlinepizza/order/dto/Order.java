package com.cg.onlinepizza.order.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Order {
	@Id
	@Column
	private int orderId;
	@Column
	private String orderType;
	@Column
	private String orderDescription;
	@Column
	private int customerId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bookingOrderId")
	private PizzaOrder pizzaorder;
	

	public Order(int orderId, String orderType, String orderDescription, int customerId
			) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.orderDescription = orderDescription;
		this.customerId = customerId;
		
	}

	public Order() {
		super();
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

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
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


}




