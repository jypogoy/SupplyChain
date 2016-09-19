package com.supplychain.inventory.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supplychain.inventory.model.User;
import com.supplychain.inventory.service.user.UserService;

@RestController
@RequestMapping("/rest")
public class UserResources {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/users")
	public String loginSuccessful() {
		return "Login Successful!";
	}
	
	@RequestMapping(value="/user/username", method=RequestMethod.POST)
	public User findByUserName(@RequestBody String userName) {
		return userService.findByUserName(userName);
	}
}
