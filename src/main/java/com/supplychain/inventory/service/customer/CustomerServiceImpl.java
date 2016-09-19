package com.supplychain.inventory.service.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.supplychain.inventory.dao.customer.CustomerDAO;
import com.supplychain.inventory.model.Customer;

@Service
@Configurable
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class.getName());
	
	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		LOGGER.info("Customer record '" + customer.toString() + "' was successfully " 
				+ (customer.getId() == 0 ? "created." : "updated."));
	}

	@Override
	public void delete(long id) {
		customerDao.delete(id);
		LOGGER.info("Customer record [" + id + "] was successfully deleted.");
	}
	
	@Override
	public Customer findById(long id) {
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> findAll(String keyword) {
		return customerDao.findAll(keyword);
	}

}
