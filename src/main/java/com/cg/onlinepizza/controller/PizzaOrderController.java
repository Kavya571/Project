package com.cg.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.dto.Pizza;
import com.cg.onlinepizza.dto.PizzaOrder;
import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.exceptions.UserNotFoundException;
import com.cg.onlinepizza.exceptions.ValidatePizzaOrderException;
import com.cg.onlinepizza.service.IPizzaOrderService;

@RestController
public class PizzaOrderController {
	@Autowired
	IPizzaOrderService ipo;
	@GetMapping("/viewOrders")
	public List<PizzaOrder> viewOrdersList() {
		return ipo.viewOrdersList();
	}

	@GetMapping("/viewPizzaOrder/{id}")
	public PizzaOrder viewPizzaOrderList(@PathVariable("id") int orderId) throws OrderIdNotFoundException {
		return ipo.viewPizzaOrder(orderId);
	}
	
	@DeleteMapping("/pizzaorder/{bookingOrderId}")
	public PizzaOrder cancelPizzaOrder(@PathVariable("bookingOrderId") int orderid) throws OrderIdNotFoundException {
		ipo.cancelPizzaOrder(orderid);
		return null;
	}
	@PostMapping("/orders")
	public int saveOrder(@RequestBody PizzaOrder orders) throws ValidatePizzaOrderException {
		double totalcost= ipo.calculateTotal(orders.getSize(),orders.getQuantity());
		orders.setTotalCost(totalcost);
		ipo.bookPizzaOrder(orders);
		return orders.getBookingId();
	}
//	@GetMapping("/viewTotalCost/{size}/{qty}")
//	public List<PizzaOrder> caluculateTotal(@PathVariable("size") String size,@PathVariable("qty") int quantity) throws OrderIdNotFoundException, InvalidSizeException {
//			return ipo.caluculateTotal(size,quantity);
//	}
	
	@PutMapping("/updateorder")
	public PizzaOrder updatePizzaOrder(@RequestBody PizzaOrder orders) {
		double totalcost= ipo.calculateTotal(orders.getSize(),orders.getQuantity());
		orders.setTotalCost(totalcost);
		ipo.updatePizzaOrder(orders);
		return orders;
	}
		

}
