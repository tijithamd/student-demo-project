package com.student.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		
		
		
		model.addAttribute("name", "Vini Dickinson");
		model.addAttribute("city", "Tampa");
		model.addAttribute("country", "USA");
		
		return "hello";
	}
}
