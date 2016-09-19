package com.supplychain.inventory.model;

import java.io.Serializable;
import java.sql.Date;

import com.supplychain.inventory.common.CustomerStatus;

import lombok.Data;

@Data
public class Customer implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date birtDate;
	private CustomerStatus status;
	
	public Customer() {}
	
	public Customer(long id, String firstName, String lastName, String email, Date birthDate, CustomerStatus status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birtDate = birthDate;
		this.status = status;
	}
	
	public Customer(String firstName, String lastName, String email, Date birthDate, CustomerStatus status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birtDate = birthDate;
		this.status = status;
	}
}
