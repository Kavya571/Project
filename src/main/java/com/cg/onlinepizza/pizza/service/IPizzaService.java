package com.cg.onlinepizza.pizza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.pizza.dao.IPizzaRepository;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.dto.Pizza;
@Service
public class IPizzaService {
	@Autowired
	IPizzaRepository IPizzaRepository;
	
	public Pizza addPizza(Pizza pizza) {
		return IPizzaRepository.save(pizza);
	}

	public Pizza updatePizza(Pizza pizza) {
		return IPizzaRepository.save(pizza);
	}

	public void deletePizza(int pizzaId) throws PizzaIdNotFoundException{
		try {
			IPizzaRepository.deleteById(pizzaId);
		}catch(Exception e) {
			throw new PizzaIdNotFoundException("Pizza Id not present in table");
		}
	}

	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException{
		try {
			return IPizzaRepository.findById(pizzaId).get();
		}catch(Exception e) {
			throw new PizzaIdNotFoundException("Pizza Id not present in table");
		}
	}

	public List<Pizza> viewPizzaList(){
		List<Pizza> pizza = new ArrayList<Pizza>();
		IPizzaRepository.findAll().forEach(pizza1 -> pizza.add(pizza1));
		return pizza;
	}

	public List<Pizza> viewPizzaList(double minCost, double maxCost)throws InvalidMinCostException{
		try {
			return IPizzaRepository.getAllbetween(minCost, maxCost);
		}catch(Exception e) {
			throw new InvalidMinCostException("Enter valid min cost");
		}
	}

}