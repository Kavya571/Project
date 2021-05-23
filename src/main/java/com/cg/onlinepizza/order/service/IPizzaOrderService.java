package com.cg.onlinepizza.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.order.dao.IPizzaOrderRepository;
import com.cg.onlinepizza.order.dto.PizzaOrder;



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

//	List<PizzaOrder> caluculateTotal(String size, int quantity) throws InvalidSizeException{
//		
//		return null;
//		
//	};
}
