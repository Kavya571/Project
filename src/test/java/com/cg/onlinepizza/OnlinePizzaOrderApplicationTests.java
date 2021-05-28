package com.cg.onlinepizza.pizza;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlinepizza.dto.Pizza;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.service.IPizzaService;

public class PizzaServiceTest extends OnlinePizzaApplicationTests {
	@Autowired
	IPizzaService service;
	@Test
	public void testAddPizza() {
		Pizza newPizz=new Pizza(1,"Medium","CheeseBurst","Vegetarian",200,100);
		newPizz=service.addPizza(newPizz);
		assertEquals("CheeseBurst",newPizz.getPizzaName());
	}
	@Test
	public void testViewPizzaPizza() {
		List<Pizza> p=service.viewPizzaList();
		assertThat(p).size().isGreaterThan(0);
		
	}
	@Test
	public void testFindPizzaById() {
		Pizza newPizz=new Pizza(2,"Large","Chicken Pizza","Non-Vegetarian",200,100);
				Pizza np=service.addPizza(newPizz);
		
				assertEquals(np.getPizzaType(),"Large");
	}
	@Test
	public void testDeletePizzaPizza() throws PizzaIdNotFoundException{
		Pizza np=new Pizza(2,"Medium","CheeseBurst","Vegetarian",200,100);
		 np=service.addPizza(np);
		 assertEquals(1,service.deletePizza(np.getPizzaId()));
	}
	@Test
	public void testUpdatePizza() {
		Pizza np=new Pizza(3,"Small","CheeseBurst","Vegetarian",300,400);
		np=service.updatePizza(new Pizza(1,"Medium","CheeseBurst","Non-Vegetarian",500,600));
		assertEquals("Non-Vegetarian",np.getPizzaDescription());
	}
}
