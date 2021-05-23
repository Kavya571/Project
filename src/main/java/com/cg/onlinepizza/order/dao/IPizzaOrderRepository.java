package com.cg.onlinepizza.order.dao;



import org.springframework.data.repository.CrudRepository;

import com.cg.onlinepizza.order.dto.PizzaOrder;


public interface IPizzaOrderRepository extends CrudRepository<PizzaOrder, Integer> {
//	PizzaOrder bookPizzaOrder(PizzaOrder order);
//
//	PizzaOrder updatePizzaOrder(PizzaOrder order);
//
//	PizzaOrder cancelPizzaOrder(int orderId) throws OrderIdNotFoundException;
//
//	PizzaOrder viewPizzaOrder(int orderId) throws OrderIdNotFoundException;
//
//	List<PizzaOrder> caluculateTotal(String size, int quantity) throws InvalidSizeException;

}

//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
///	@Query(value="select * from pizza where pizza_cost between :minCost and :maxCost", nativeQuery = true)
//	List<Pizza> getAllbetween(@Param("minCost")double minCost,@Param("maxCost") double maxCost);
//
//Pizza addPizza(Pizza pizza);
//
//Pizza updatePizza(Pizza pizza);
//
//Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException;
//
//Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException;
//
//List<Pizza> viewPizzaList();
//
//List<Pizza> viewPizzaList(double minCost, double maxCost)throws InvalidMinCostException;
//
//}

//
//}