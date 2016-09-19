package com.supplychain.inventory.service.user;

import java.util.List;

import com.supplychain.inventory.model.User;

public interface UserService {

	public void insert(User user);
	
	public User findById(int id);
	
	public User findByUserName(String userName);
	
	public List<User> findAll();
	
	public List<User> findAll(String keyword);
	
}
