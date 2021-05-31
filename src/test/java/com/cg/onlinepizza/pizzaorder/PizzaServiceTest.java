package com.cg.onlinepizza.pizza;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlinepizza.dto.Pizza;
import com.cg.onlinepizza.exceptions.PizzaException;
import com.cg.onlinepizza.exceptions.PizzaFoundException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.exceptions.ValidatePizzaException;
import com.cg.onlinepizza.service.IPizzaService;

public class PizzaServiceTest extends OnlinePizzaApplicationTests {
	@Autowired
	IPizzaService service;
	@Test
	public void testAddPizza() throws PizzaFoundException, ValidatePizzaException {
		Pizza newPizz=new Pizza(1,"Medium","CheeseBurst","Vegetarian",200,100);
		assertThrows(ValidatePizzaException.class,()->service.addPizza(newPizz));
	}
	@Test
	public void testAddPizza1() throws PizzaFoundException, ValidatePizzaException {
		Pizza newPizz=new Pizza(10,"Large","Cheese Burst","Vegetarian",200,100);
		newPizz=service.addPizza(newPizz);
		assertEquals("Cheese Burst",newPizz.getPizzaName());
	}
	@Test
	public void testViewPizzaPizza() throws PizzaException {
		List<Pizza> p=service.viewPizzaList();
		assertThat(p).size().isGreaterThan(0);
		
	}
	@Test
	public void testFindPizzaById() throws PizzaFoundException, ValidatePizzaException {
		Pizza newPizz=new Pizza(15,"Large","Chicken Pizza","Non Vegetarian",200,100);
				Pizza np=service.addPizza(newPizz);
		
				assertEquals(np.getPizzaType(),"Large");
	}
	@Test
	public void testDeletePizzaPizza() throws PizzaIdNotFoundException, PizzaFoundException, ValidatePizzaException{
		Pizza np=new Pizza(16,"Medium","Cheese Burst","Vegetarian",200,100);
		 np=service.addPizza(np);
		 assertEquals(16,service.deletePizza(np.getPizzaId()));
	}
	@Test
	public void testUpdatePizza() throws PizzaIdNotFoundException, ValidatePizzaException {
		Pizza np=new Pizza(9,"Small","Cheese Burst","Vegetarian",300,400);
		np=service.updatePizza(new Pizza(9,"Medium","Cheese Burst","Non Vegetarian",500,600));
		assertEquals("Non Vegetarian",np.getPizzaDescription());
	}
}
