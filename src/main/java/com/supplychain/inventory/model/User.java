package com.supplychain.inventory.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class User implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Timestamp dateCreated;
	
	public User() {}
	
	public User(Long id, String userName, String firstName, String lastName, String password, Timestamp dateCreated) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateCreated = dateCreated;
	}
	
	public User(String userName, String firstName, String lastName, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
}
