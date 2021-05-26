package com.cg.onlinepizza.service;

import java.util.List;

import com.cg.onlinepizza.dto.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;

	List<Customer> viewCustomers();

	Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;
}
