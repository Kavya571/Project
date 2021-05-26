package com.cg.onlinepizza.order.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cg.onlinepizza.coupan.dto.Coupan;
import com.cg.onlinepizza.pizza.dto.Pizza;


@Entity
public class PizzaOrder {
	@Id
	@GeneratedValue
	@Column
	private int bookingOrderId;
	@Column
	private LocalDate dateOfOrder;
	@Column
	private String transactionMode;
	@Column
	private int quantity;
	@Column
	private String size;//medium,regular,large
	@Column
	private double totalCost;
//	@Column
//	private Pizza pizza;
//	@Column
//	private Order order;

	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinTable(name = "pizzaorder_coupan_mapping", joinColumns = {@JoinColumn(name = "bookingOrderId")}, inverseJoinColumns = {@JoinColumn(name = "coupan_Id")})
	private Coupan coupan;

	
	public int getBookingOrderId() {
		return bookingOrderId;
	}
	public void setBookingOrderId(int bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
//	public Pizza getPizza() {
//		return pizza;
//	}
//	public void setPizza(Pizza pizza) {
//		this.pizza = pizza;
//	}
//	public Order getOrder() {
//		return order;
//	}
//	public void setOrder(Order order) {
//		this.order = order;
//	}
	public Coupan getCoupan() {
		return coupan;
	}
	public void setCoupan(Coupan coupan) {
		this.coupan = coupan;
	} 
	
}