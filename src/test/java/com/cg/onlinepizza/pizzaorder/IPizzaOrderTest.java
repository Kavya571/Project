package com.cg.onlinepizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import com.cg.onlinepizza.dto.*;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.service.IPizzaOrderService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IPizzaOrderServiceTest extends OnlinePizzaOrderApplicationTests {
	@Autowired
	IPizzaOrderService service;

	@Test
	void testIPizzaOrderService() {
		assertTrue(service instanceof IPizzaOrderService);
	}

	@Test
	public void testBookPizzaOrder() {
		PizzaOrder orders = new PizzaOrder(1, LocalDate.of(2020, 01, 18) ,"online",3,"small",500.00);
		orders = service.bookPizzaOrder(orders);
		assertEquals(orders.getBookingId(),1);
	}

	@Test
	void testupdatePizzaOrder() {
		PizzaOrder orders = new PizzaOrder(3, LocalDate.of(2021, 10, 28) ,"online",4,"medium",900.00);
		orders = service.updatePizzaOrder(orders);
		assertEquals(orders.getSize(), "medium"); 
	}

  @Test
	void testcancelPizzaOrder() throws OrderIdNotFoundException{
		
		int bookingId = service.cancelPizzaOrder(1);
		assertEquals(bookingId,1);
	}

	@Test
	void testViewPizzaOrderList() throws OrderIdNotFoundException {
		
		PizzaOrder pizzaord = service.viewPizzaOrder(2);
		assertEquals(pizzaord.getBookingId(), 2);
		
	}

	@Test
	void testViewOrdersList() {
		List<PizzaOrder> ord = service.viewOrdersList();
		assertNotNull(ord);
	}

}
