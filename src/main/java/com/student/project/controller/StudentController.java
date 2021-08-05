package com.student.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.project.dataobjects.Student;
import com.student.project.service.StudentService;

@Controller
@RequestMapping(path = "student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(path = "/home")
	public String home() {
		return "students";
	}
	
	@GetMapping(path = "/view")
	public String view(@RequestParam(name = "studId") int studId, Model model) {
		
		try {
			Student stud = studentService.view(studId);
			model.addAttribute("success", true);
			model.addAttribute("student", stud);
		} 
		catch (Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		
		return "studentdisplay";
	}
	
	@GetMapping(path = "/new")
	public String createNew() {
		return "studentcreate";
	}
	
	@PostMapping(path = "/create")
	public String create(@RequestParam(name = "name") String name, 
						 @RequestParam(name = "city") String city, 
						 @RequestParam(name = "country") String country, 
						 Model model) 
	{
		Student student = new Student();
		student.setName(name);
		student.setCity(city);
		student.setCountry(country);
		try{
			studentService.create(student);
			model.addAttribute("success", true);
			model.addAttribute("message", "Student successfully created.");
		}
		catch (Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		
		return "studentcreate";
	}
}
