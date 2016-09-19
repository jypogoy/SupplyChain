package com.supplychain.inventory.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychain.inventory.model.Customer;
import com.supplychain.inventory.service.customer.CustomerService;

@RestController
@RequestMapping("/rest")
public class CustomerResources {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> findAll(String keyword) {
		return customerService.findAll(keyword);
	}
	
	@RequestMapping("/customers/id")
	public Customer findById(long id) {
		return customerService.findById(id);
	}
}
