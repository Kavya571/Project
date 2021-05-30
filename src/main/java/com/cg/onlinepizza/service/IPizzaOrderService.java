package com.cg.onlinepizza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dto.PizzaOrder;
import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.exceptions.UserNotFoundException;
import com.cg.onlinepizza.exceptions.ValidatePizzaOrderException;
import com.cg.onlinepizza.repository.IPizzaOrderRepository;
import com.cg.onlinepizza.util.OnlinePizzaOrderConstants;


@Service
public class IPizzaOrderService {
	@Autowired
	IPizzaOrderRepository IPizzaOrderRepository;
	
	public PizzaOrder bookPizzaOrder(PizzaOrder orders) {
		return IPizzaOrderRepository.save(orders);
	}

	public PizzaOrder updatePizzaOrder(PizzaOrder orders) {
		return IPizzaOrderRepository.save(orders);
	}

	public int cancelPizzaOrder(int orderId) throws OrderIdNotFoundException{
		try {
			IPizzaOrderRepository.deleteById(orderId);
			return orderId;
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
	
	public boolean ValidatePizzaOrder(PizzaOrder pizzaorder) throws ValidatePizzaOrderException {
		if(!pizzaorder.getSize().matches("[A-Za-z]||[z-aA-Z"))
			throw new ValidatePizzaOrderException(OnlinePizzaOrderConstants.PIZZAORDER_CANNOT_BE_EMPTY);
				
		if(!(pizzaorder.getQuantity()==0))
			throw new ValidatePizzaOrderException(OnlinePizzaOrderConstants.PIZZAORDER_CANNOT_BE_EMPTY);
				
			return true;
	}
	
	
	public List<PizzaOrder> caluculateTotal(String size, int quantity) throws InvalidSizeException{
		List<PizzaOrder> pizzaList= new ArrayList<PizzaOrder>(); // caluculateTotal(size,quantity);
		return pizzaList;
		
	}
	
	public double calculateTotal(String size, int quantity) {
		double totalCost;
		if(size=="small") {
			totalCost=100.00*quantity;
			return totalCost;
		}
		else if(size=="medium") {
			totalCost = 200.00*quantity;
			return totalCost;
		}
		else {
			totalCost = 300.00*quantity;
			return totalCost;
		}
	
	}
	
}
