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

import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.service.ICustomerService;
import com.cg.onlinepizza.dto.Customer;

@RestController
public class CustomerController {
	@Autowired
	ICustomerService ics;
	@GetMapping("/viewCustomer")
	public List<Customer> viewCustomers() {
		return ics.viewCustomers();
	}
	@GetMapping("/viewCustomer/{id}")
	public Customer viewCustomers(@PathVariable("id") int customerId) throws CustomerIdNotFoundException {
		return ics.viewCustomer1(customerId);
	}
//	@GetMapping("/viewPizza/{minCost}/{maxCost}")
//	private List<Pizza> viewPizzaList(@PathVariable("minCost") double minCost,@PathVariable("maxCost") double maxCost){
//		return ips.viewPizzaList();
//	}
	@DeleteMapping("/customer/{customerId}")
	public Customer deleteCustomer(@PathVariable("customerId") int id) throws CustomerIdNotFoundException {
		ics.deleteCustomer(id);
		return null;
	}

	@PostMapping("/customer")
	public int saveCust(@RequestBody Customer customer) {
		ics.addCustomer(customer);
		return customer.getCustomerId();
	}

	@PutMapping("/updateCustomer")
	public Customer update(@RequestBody Customer customer) {
		ics.updateCustomer(customer);
		return customer;
	}
}
