package com.cg.onlinepizza.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.exceptions.ValidateCustomerException;
import com.cg.onlinepizza.repository.ICustomerRepository;
import com.cg.onlinepizza.util.OnlinePizzaConstants;
import com.cg.onlinepizza.dto.Customer;


@Service
public class ICustomerService {
	@Autowired
	ICustomerRepository ICustomerRepository;
	public Customer addCustomer(Customer customer) throws ValidateCustomerException {
		validateCustomer(customer);
		return ICustomerRepository.save(customer);
		
	}

	public Customer updateCustomer(Customer customer) {
		return ICustomerRepository.save(customer);
	}

	public int deleteCustomer(int customerId) throws CustomerIdNotFoundException{
		try {
			ICustomerRepository.deleteById(customerId);
			return customerId;
		}
		catch(Exception e) {
			throw new CustomerIdNotFoundException("Customer Id not present in table");
		}
	}
	
	public boolean validateCustomer(Customer customer) throws ValidateCustomerException {
		if (!customer.getCustomerName().matches("[A-Za-z]+")) {
			throw new ValidateCustomerException(OnlinePizzaConstants.CUSTOMER_CANNOT_BE_EMPTY);
		}
		
		if (!customer.getUserName().matches("[A-Za-z0-9]+")) {
			throw new ValidateCustomerException(OnlinePizzaConstants.USERNAME_CANNOT_BE_EMPTY);
		}
		String customerMobileNumberString = Long.toString(customer.getCustomerMobile());
		
		if (!customerMobileNumberString.matches("^[6-9][0-9]{9}")) {
			throw new ValidateCustomerException(OnlinePizzaConstants.MOBILENUMBER_CANNOT_BE_EMPTY);
		}
		if (!customer.getCustomerEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			throw new ValidateCustomerException(OnlinePizzaConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		
		if (!customer.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
			throw new ValidateCustomerException(OnlinePizzaConstants.PASSWORD_CANNOT_BE_EMPTY);
		}
		if (!customer.getCustomerAddress().matches("^[#.0-9a-zA-Z\\s,-]+$")) {
			throw new ValidateCustomerException(OnlinePizzaConstants.ADDRESS_CANNOT_BE_EMPTY);
		}
		

		return true;
	}
	
	public Customer viewCustomer1(int customerId) throws CustomerIdNotFoundException{
		try {
			return ICustomerRepository.findById(customerId).get();
		}
		catch(Exception e) {
			throw new CustomerIdNotFoundException("Customer Id not present in table");
		}
	}

	public List<Customer> viewCustomers(){
		List<Customer> customer = new ArrayList<Customer>();
		ICustomerRepository.findAll().forEach(customer1 -> customer.add(customer1));
		return customer;
	}

}
