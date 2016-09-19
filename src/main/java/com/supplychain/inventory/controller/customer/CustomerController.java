package com.supplychain.inventory.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supplychain.inventory.model.Customer;
import com.supplychain.inventory.service.customer.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customerslist")
	public String customerList(Model model) {
		return "customers";
	}
	
	@RequestMapping("/customer-edit")
	public String customerDetail(Model model) {
		return "customer-edit";
	}
	
}
