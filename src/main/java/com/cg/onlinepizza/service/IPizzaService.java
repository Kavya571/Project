package com.cg.onlinepizza.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.dto.Pizza;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaException;
import com.cg.onlinepizza.exceptions.PizzaFoundException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.exceptions.ValidatePizzaException;
import com.cg.onlinepizza.util.OnlinePizzaConstants;
@Service
public class IPizzaService {
	@Autowired
	IPizzaRepository IPizzaRepository;
	public boolean validatePizza(Pizza pizza) throws ValidatePizzaException{
		if(!pizza.getPizzaName().matches("([a-zA-Z])|([A-Za-z]+[ ]{1}[a-zA-Z]+)")) {
			throw new ValidatePizzaException(OnlinePizzaConstants.PIZZA_NAME_CANNOT_BE_EMPTY);
		}
		String pizzaCostString=Double.toString(pizza.getPizzaCost());
		if(!pizzaCostString.matches("[0-9]+([\\.][0-9]{1,2})?")) {
			throw new ValidatePizzaException(OnlinePizzaConstants.PIZZA_COST_CANNOT_BE_EMPTY);
		}
		if(!String.valueOf(pizza.getPizzaCostAfterCoupan()).matches("[0-9]+([\\.][0-9]{1,2})?")) {
			throw new ValidatePizzaException(OnlinePizzaConstants.PIZZA_COST_AFTER_CUOPAN_CANNOT_BE_EMPTY);
		}
		if(!pizza.getPizzaType().matches("([A-Za-z])+")) {
			throw new ValidatePizzaException(OnlinePizzaConstants.PIZZA_TYPE_CANNOT_BE_EMPTY);
		}
		if(!pizza.getPizzaDescription().matches("[\\w ]+")) {
			throw new ValidatePizzaException(OnlinePizzaConstants.PIZZA_DESCRIPTION_CANNOT_BE_EMPTY);
		}
		return true;
		
	}
	public Pizza addPizza(Pizza pizza) throws PizzaFoundException, ValidatePizzaException {
		validatePizza(pizza);
		Optional<Pizza> optpizza=IPizzaRepository.findById(pizza.getPizzaId());
		if(!optpizza.isPresent()) {
			return IPizzaRepository.save(pizza);
		}
		throw new PizzaFoundException("pizza id already exists");
		
	}
	public Pizza updatePizza(Pizza pizza) throws PizzaIdNotFoundException, ValidatePizzaException {
		Optional<Pizza> optpizza=IPizzaRepository.findById(pizza.getPizzaId());
		if(optpizza.isPresent()) {
			validatePizza(pizza);
			return IPizzaRepository.save(pizza);
		}
		throw new PizzaIdNotFoundException("Pizza is not available to update");
	}

	public int deletePizza(int pizzaId) throws PizzaIdNotFoundException{
		Optional<Pizza> optpizza=IPizzaRepository.findById(pizzaId);
		if(!optpizza.isPresent()) {
			throw new PizzaIdNotFoundException("Pizza is not available ");
		}
		IPizzaRepository.deleteById(pizzaId);
		return pizzaId;
	}

	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException{
		Optional<Pizza> optpizza=IPizzaRepository.findById(pizzaId);
		if(!optpizza.isPresent()) {
			throw new PizzaIdNotFoundException("Pizza is not available with the given id");
		}
		return IPizzaRepository.findById(pizzaId).get();
	}

	public List<Pizza> viewPizzaList() throws PizzaException{
		List<Pizza> pizza = new ArrayList<Pizza>();
		IPizzaRepository.findAll().forEach(pizza1 -> pizza.add(pizza1));
		if(pizza.isEmpty()) {
			throw new PizzaException("Pizza is empty");
		}
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
