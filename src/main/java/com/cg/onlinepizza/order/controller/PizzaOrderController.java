package com.cg.onlinepizza.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.order.dto.PizzaOrder;
import com.cg.onlinepizza.order.service.IPizzaOrderService;

@RestController
public class PizzaOrderController {
	@Autowired
	IPizzaOrderService ipo;

	@GetMapping("/viewPizzaOrder/{id}")
	private PizzaOrder viewPizzaOrderList(@PathVariable("id") int orderId) throws OrderIdNotFoundException {
		return ipo.viewPizzaOrder(orderId);
	}
	
	@DeleteMapping("/pizzaorder/{orderId}")
	private void cancelPizzaOrder(@PathVariable("orderId") int orderid) throws OrderIdNotFoundException {
		ipo.cancelPizzaOrder(orderid);
	}

	@PostMapping("/order")
	private int saveOrder(@RequestBody PizzaOrder order) {
		ipo.bookPizzaOrder(order);
		return order.getBookingOrderId();
	}

	@PutMapping("/update")
	private PizzaOrder updatePizzaOrder(@RequestBody PizzaOrder order) {
		ipo.updatePizzaOrder(order);
		return order;
	}
	
	

}