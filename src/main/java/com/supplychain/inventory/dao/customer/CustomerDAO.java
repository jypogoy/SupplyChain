package com.supplychain.inventory.dao.customer;

import java.util.List;

import com.supplychain.inventory.model.Customer;

/**
 * This interface declares all known activities in handling customer records.
 * @author jeffrey.pogoy
 *
 */
public interface CustomerDAO {

	/**
	 * Creates a new customer record. An update will be made in case a record already exists.
	 * @param customer
	 */
	public void save(Customer customer);
	
	/**
	 * Removes a customer record using a particular id.
	 * @param id
	 */
	public void delete(long id);
	
	/**
	 * Retrieves customer record using a specific id.
	 * @param id
	 * @return customer record
	 */
	public Customer findById(long id);
	
	/**
	 * Retrieves customer records. May provide filtered values using a keyword.
	 * @param keyword
	 * @return list of customer records
	 */
	public List<Customer> findAll(String keyword);
	
}
