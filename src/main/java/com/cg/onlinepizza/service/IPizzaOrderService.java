package com.cg.onlinepizza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dto.PizzaOrder;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.repository.IPizzaOrderRepository;


@Service
public class IPizzaOrderService {
	@Autowired
	IPizzaOrderRepository IPizzaOrderRepository;
	
	public PizzaOrder bookPizzaOrder(PizzaOrder order) {
		return IPizzaOrderRepository.save(order);
	}

	public PizzaOrder updatePizzaOrder(PizzaOrder order) {
		return IPizzaOrderRepository.save(order);
	}

	public void cancelPizzaOrder(int orderId) throws OrderIdNotFoundException{
		try {
			IPizzaOrderRepository.deleteById(orderId);
		}catch(Exception e) {
			throw new OrderIdNotFoundException("Order Id not present in table");
		}
		
	}
	public PizzaOrder viewPizzaOrder(int orderId) throws OrderIdNotFoundException{
		try {
			return IPizzaOrderRepository.findById(orderId).get();
		}catch(Exception e) {
			throw new OrderIdNotFoundException("Order Id not present in table");
		}
	}
	
	public List<PizzaOrder> viewOrdersList(){
		List<PizzaOrder> pizzaorder = new ArrayList<PizzaOrder>();
		IPizzaOrderRepository.findAll().forEach(pizzaorder1 -> pizzaorder.add(pizzaorder1));
		return pizzaorder;
	}

//	public List<PizzaOrder> caluculateTotal(String size, int quantity) throws InvalidSizeException{
//		List<PizzaOrder> pizzaList= caluculateTotal(size,quantity);
//		return pizzaList;
//		
//	}
	
}
