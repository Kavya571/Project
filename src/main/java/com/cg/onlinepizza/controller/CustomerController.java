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
import com.cg.onlinepizza.exceptions.ValidateCustomerException;
import com.cg.onlinepizza.service.ICustomerService;
import com.cg.onlinepizza.util.OnlinePizzaConstants;
import com.cg.onlinepizza.dto.Customer;
import com.cg.onlinepizza.dto.SuccessMsg;

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
	
	@DeleteMapping("/customer/{customerId}")
	public SuccessMsg deleteCustomer(@PathVariable("customerId") int id) throws CustomerIdNotFoundException {
		ics.deleteCustomer(id);
		return new SuccessMsg(OnlinePizzaConstants.CUSTOMER_DELETED);
	}

	@PostMapping("/customer")
	public SuccessMsg saveCust(@RequestBody Customer customer) throws ValidateCustomerException {
		ics.addCustomer(customer);
		return new SuccessMsg(OnlinePizzaConstants.CUSTOMER_DELETED + customer.getCustomerId());
	}

	@PutMapping("/updateCustomer")
	public SuccessMsg update(@RequestBody Customer customer) {
		ics.updateCustomer(customer);
		return new SuccessMsg(OnlinePizzaConstants.CUSTOMER_DELETED + customer);
	}
}
