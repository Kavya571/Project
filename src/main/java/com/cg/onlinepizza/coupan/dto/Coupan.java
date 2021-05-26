
package com.cg.onlinepizza.coupan.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.onlinepizza.order.dto.PizzaOrder;

@Entity
public class Coupan {
	@Id
	@GeneratedValue
	@Column
	private int coupanId;
	@Column
	private String coupanName;
	@Column
	private String coupanType;
	@Column
	private String coupanDescription;
	@Column
	private int coupanPizzaId;
	
//	@OneToOne//(mappedBy = "coupan1")
//	private PizzaOrder pizzaorder;
//	
////	@OneToOne(cascade= CascadeType.ALL)
////   // @JoinColumn(name="bookingOrderId",referencedColumnName="bookingOrderId")
////	private PizzaOrder pizzaorder;
	

//	
//	public PizzaOrder getPizzaorder() {
//		return pizzaorder;
//	}
//
//	public void setPizzaorder(PizzaOrder pizzaorder) {
//		this.pizzaorder = pizzaorder;
//	}

	public Coupan(int coupanId, String coupanName, String coupanType, String coupanDescription, int coupanPizzaId//,PizzaOrder pizzaorder
			) {
		super();
		this.coupanId = coupanId;
		this.coupanName = coupanName;
		this.coupanType = coupanType;
		this.coupanDescription = coupanDescription;
		this.coupanPizzaId = coupanPizzaId;
		//this.pizzaorder = pizzaorder;
	}

	public int getCoupanId() {
		return coupanId;
	}

	public void setCoupanId(int coupanId) {
		this.coupanId = coupanId;
	}

	public String getCoupanName() {
		return coupanName;
	}

	public Coupan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCoupanName(String coupanName) {
		this.coupanName = coupanName;
	}

	public String getCoupanType() {
		return coupanType;
	}

	public void setCoupanType(String coupanType) {
		this.coupanType = coupanType;
	}

	public String getCoupanDescription() {
		return coupanDescription;
	}

	public void setCoupanDescription(String coupanDescription) {
		this.coupanDescription = coupanDescription;
	}

	public int getCoupanPizzaId() {
		return coupanPizzaId;
	}

	public void setCoupanPizzaId(int coupanPizzaId) {
		this.coupanPizzaId = coupanPizzaId;
	}

}

