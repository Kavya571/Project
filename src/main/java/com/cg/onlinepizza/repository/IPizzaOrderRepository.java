package com.cg.onlinepizza.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.onlinepizza.dto.PizzaOrder;
import com.cg.onlinepizza.exceptions.InvalidSizeException;


public interface IPizzaOrderRepository extends CrudRepository<PizzaOrder, Integer> {
//	@Query(value="select * from pizzaoder where size=:size and quantity=: quantity", nativeQuery = true)
//	List<PizzaOrder> caluculateTotal(@Param("size")String size,@Param("quantity") int quantity) throws InvalidSizeException;
//	
}

