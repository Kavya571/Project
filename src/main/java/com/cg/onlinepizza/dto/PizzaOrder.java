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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private LocalDate dateOfOrder;
	private String transactionMode;
	private int quantity;
	private String size;// medium,regular,large

	private double totalCost;
	
	@OneToOne(cascade= CascadeType.ALL)
	private Order orders;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Coupan coupan;
	
	@OneToMany(targetEntity=Pizza.class,cascade = CascadeType.ALL)
	@JoinColumn(name="bookingId",referencedColumnName="bookingId")
	private List<Pizza> pizza;

	
	public PizzaOrder(int bookingId, LocalDate dateOfOrder, String transactionMode, int quantity, String size,
			double totalCost//,Coupan coupan
			) {
		super();
		this.bookingId = bookingId;
		this.dateOfOrder = dateOfOrder;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.size = size;
		this.totalCost = totalCost;
		//this.coupan = coupan;
	}
	public PizzaOrder() {
	
	}
	
	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
	
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public Coupan getCoupan() {
		return coupan;
	}

	public void setCoupan(Coupan coupan) {
		this.coupan = coupan;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

}