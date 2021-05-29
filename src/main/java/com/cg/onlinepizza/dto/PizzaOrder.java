package com.cg.onlinepizza.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int bookingOrderId;
	private LocalDate dateOfOrder;
	private String transactionMode;
	private int quantity;
	private String size;//medium,regular,large
	private double totalCost;
	@OneToMany(targetEntity=Pizza.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "bookingOrderId",referencedColumnName="bookingOrderId")
	private List<Pizza> pizza;
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;
	@OneToOne(cascade = CascadeType.ALL)
	private Coupan coupan;	
	public PizzaOrder() {
		super();

	}
	public PizzaOrder(int bookingOrderId, LocalDate dateOfOrder, String transactionMode, int quantity, String size,
			double totalCost) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.dateOfOrder = dateOfOrder;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.size = size;
		this.totalCost = totalCost;
	}
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
	
	public List<Pizza> getPizza() {
		return pizza;
	}
	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Coupan getCoupan() {
		return coupan;
	}
	public void setCoupan(Coupan coupan) {
		this.coupan = coupan;
	} 
	
}
