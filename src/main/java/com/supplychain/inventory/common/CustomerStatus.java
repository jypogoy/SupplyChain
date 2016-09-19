package com.supplychain.inventory.common;

public enum CustomerStatus {

	ImportLead,
	NonContacted,
	Contacted,
	Customer,
	ClosedLost;
	
	public String value() {
		return name();
	}
	
	public static CustomerStatus fromValue(String value) {
		return valueOf(value);
	}
}
