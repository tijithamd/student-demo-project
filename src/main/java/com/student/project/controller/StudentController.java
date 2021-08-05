package com.student.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
