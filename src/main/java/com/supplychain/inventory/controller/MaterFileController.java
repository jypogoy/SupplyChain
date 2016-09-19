package com.supplychain.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MaterFileController {

	@RequestMapping("/items")
	public String items() {
		return "items";
	}
	
	@RequestMapping("/suppliers")
	public String suppliers() {
		return "suppliers";
	}
	
	@RequestMapping("/customers")
	public String customers() {
		return "customers";
	}
	
	@RequestMapping("/truckers")
	public String truckers() {
		return "truckers";
	}
	
	@RequestMapping("/locations")
	public String locations() {
		return "locations";
	}
}
