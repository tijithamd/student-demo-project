package com.student.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.project.dataobjects.Student;
import com.student.project.service.StudentService;

@RestController
@RequestMapping(path = "studentrest")
public class StudentWebService {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path = "/view")
	public String view(@RequestParam(name = "id") int id) {
		
		String result = null;

		try {
			Student stud = studentService.view(id);
			result = stud.toString();
		} 
		catch (Exception e) {
			result = e.getMessage();
		}
		
		return result;
	}
	
	@PostMapping(path = "/update")
	public Student create(@RequestParam(name = "id") int id) {
		
		Student student = new Student();
		student.setId(id);
		
		return studentService.create(student);
	}
}
