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

import com.cg.onlinepizza.dto.PizzaOrder;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.service.IPizzaOrderService;


@RestController
public class PizzaOrderController {
	@Autowired
	IPizzaOrderService ipo;
	@GetMapping("/viewOrders")
	private List<PizzaOrder> viewOrdersList() {
		return ipo.viewOrdersList();
	}

	@GetMapping("/viewPizzaOrder/{id}")
	private PizzaOrder viewPizzaOrderList(@PathVariable("id") int orderId) throws OrderIdNotFoundException {
		return ipo.viewPizzaOrder(orderId);
	}
	
	@DeleteMapping("/pizzaorder/{bookingOrderId}")
	private void cancelPizzaOrder(@PathVariable("bookingOrderId") int orderid) throws OrderIdNotFoundException {
		ipo.cancelPizzaOrder(orderid);
	}

	@PostMapping("/orders")
	private int saveOrder(@RequestBody PizzaOrder orders) {
		ipo.bookPizzaOrder(orders);
		return orders.getBookingId();
	}
	

	@PutMapping("/updateorder")
	private PizzaOrder updatePizzaOrder(@RequestBody PizzaOrder orders) {
		ipo.updatePizzaOrder(orders);
		return orders;
	}
	
	

}