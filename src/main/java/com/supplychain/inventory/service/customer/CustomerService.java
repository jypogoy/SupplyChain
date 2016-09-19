package com.supplychain.inventory.service.customer;

import java.util.List;

import com.supplychain.inventory.model.Customer;

public interface CustomerService {

	public void save(Customer customer);
	
	public void delete(long id);
	
	public Customer findById(long id);
	
	public List<Customer> findAll(String keyword);
	
}
