package com.student.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/login")
	public String loginStudent() {
		return "Hello";
	}
}
