package com.supplychain.inventory.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.supplychain.inventory.dao.user.UserDAO;
import com.supplychain.inventory.model.User;

@Service
@Configurable
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserDAO userDao;
	
	public synchronized void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public synchronized User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}
	
	@Override
	public synchronized List<User> findAll() {
		return userDao.findAll();
	}
	
	@Override
	public synchronized List<User> findAll(String keyword) {
		return userDao.findAll(keyword);
	}

}
