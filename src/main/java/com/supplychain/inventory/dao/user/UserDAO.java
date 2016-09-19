package com.supplychain.inventory.dao.user;

import java.util.List;

import com.supplychain.inventory.model.User;

/**
 * This interface declares all known activities in handling user records.
 * @author jeffrey.pogoy
 *
 */
public interface UserDAO {

	/**
	 * Creates new user record.
	 * @param user object that contains information from user input.
	 */
	public void insert(User user);
	
	/**
	 * Retrieves user record using a specific id.
	 * @param id
	 * @return user record
	 */
	public User findById(long id);
	
	/**
	 * Retrieves user record using a specific user name.
	 * @param name
	 * @return
	 */
	public User findByUserName(String userName);
	
	/**
	 * Retrieves list of all user records. 
	 * @return list of user records 
	 */
	public List<User> findAll();
	
	/**
	 * Retrieves user records using a keyword.
	 * @param keyword
	 * @return list of user records
	 */
	public List<User> findAll(String keyword);
	
}
