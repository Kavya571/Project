package com.cg.onlinepizza.pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.dto.Pizza;
import com.cg.onlinepizza.pizza.service.IPizzaService;

@RestController
public class PizzaController {
	@Autowired
	IPizzaService ips;
	@GetMapping("/viewPizza")
	private List<Pizza> viewPizzaList() {
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
	private void deletePizza(@PathVariable("pizzaId") int id) throws PizzaIdNotFoundException {
		ips.deletePizza(id);
	}

	@PostMapping("/pizza")
	private int save(@RequestBody Pizza pizza) {
		ips.addPizza(pizza);
		return pizza.getPizzaId();
	}

	@PutMapping("/update")
	private Pizza update(@RequestBody Pizza pizza) {
		ips.updatePizza(pizza);
		return pizza;
	}
	
}