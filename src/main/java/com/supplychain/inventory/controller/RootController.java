package com.supplychain.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	private static final String greetTemplate = "Hello, %s!";
	
	@RequestMapping("/SupplyChain")
	public String home(Model model) {
		String message = String.format(greetTemplate, "Jeff");
		model.addAttribute("message", message);
		return "home";
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
