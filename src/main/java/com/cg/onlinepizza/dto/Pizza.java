package com.cg.onlinepizza.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Pizza")

public class Pizza {
	@Id
	@GeneratedValue
	@Column
	private int pizzaId;
	@Column
	private String pizzaType;
	@Column
	private String pizzaName;
	@Column
	private String pizzaDescription;
	@Column
	private double pizzaCost;
	@Column
	private double pizzaCostAfterCoupan;
	

//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "bookingOrderId")
//	private PizzaOrder pizzaorder;
//	
//	public PizzaOrder getPizzaorder() {
//		return pizzaorder;
//	}
//	public void setPizzaorder(PizzaOrder pizzaorder) {
//		this.pizzaorder = pizzaorder;
//	}
	public int getPizzaId() {
		return pizzaId;
	}
	public Pizza() {
		super();
	}
	public Pizza(int pizzaId, String pizzaType, String pizzaName, String pizzaDescription, double pizzaCost,
			double pizzaCostAfterCoupan//, PizzaOrder pizzaorder
			) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.pizzaDescription = pizzaDescription;
		this.pizzaCost = pizzaCost;
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	//	this.pizzaorder = pizzaorder;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaDescription() {
		return pizzaDescription;
	}
	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}
	public double getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	public double getPizzaCostAfterCoupan() {
		return pizzaCostAfterCoupan;
	}
	public void setPizzaCostAfterCoupan(double pizzaCostAfterCoupan) {
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;

	}
	
}