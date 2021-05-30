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
import com.cg.onlinepizza.dto.SuccessMsg;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaException;
import com.cg.onlinepizza.exceptions.PizzaFoundException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.exceptions.ValidatePizzaException;
import com.cg.onlinepizza.service.IPizzaService;
import com.cg.onlinepizza.util.OnlinePizzaConstants;


@RestController
public class PizzaController {
	@Autowired
	IPizzaService ips;
	@GetMapping("/viewPizza")
	private List<Pizza> viewPizzaList() throws PizzaException {
		return ips.viewPizzaList();
	}
	@GetMapping("/viewPizza/{id}")
	private Pizza viewPizzaList(@PathVariable("id") int pizzaId) throws PizzaIdNotFoundException {
		return ips.viewPizza(pizzaId);
	}
	@GetMapping("/viewPizza/{minCost}/{maxCost}")
	private List<Pizza> viewPizzaList(@PathVariable("minCost") double minCost,@PathVariable("maxCost") double maxCost) throws InvalidMinCostException{
		return ips.viewPizzaList(minCost,maxCost);
	}
	@DeleteMapping("/pizza/{pizzaId}")
	private SuccessMsg deletePizza(@PathVariable("pizzaId") int id) throws PizzaIdNotFoundException {
		ips.deletePizza(id);
		return new SuccessMsg(OnlinePizzaConstants.PIZZA_DELETED);
	}

	@PostMapping("/pizza")
	private SuccessMsg savePizza(@RequestBody Pizza pizza) throws PizzaFoundException, ValidatePizzaException {
		return new SuccessMsg(OnlinePizzaConstants.PIZZA_ADDED+pizza.getPizzaId());
	}

	@PutMapping("/update")
	private SuccessMsg update(@RequestBody Pizza pizza) throws PizzaIdNotFoundException, ValidatePizzaException {
		ips.updatePizza(pizza);
		return new SuccessMsg(OnlinePizzaConstants.PIZZA_UPDATED+pizza.getPizzaId());
	}
	
}
