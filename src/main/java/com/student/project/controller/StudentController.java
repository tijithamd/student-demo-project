package com.student.project.controller;

import java.util.List;

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
	public String viewAll(Model model) {
		
		List<Student> students = studentService.viewAll();
		model.addAttribute("students", students);
		
		return "studentviewall";
	}
	
	@GetMapping(path = "/display")
	public String viewById(@RequestParam(name = "id") int studId, Model model) {
		
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
	public String create(@RequestParam(name = "firstname") String firstname,
						 @RequestParam(name = "lastname") String lastname,
						 @RequestParam(name = "gender") String gender,
						 @RequestParam(name = "address") String address,
						 @RequestParam(name = "city") String city, 
						 @RequestParam(name = "country") String country,
						 @RequestParam(name = "zip") int zip, 
						 @RequestParam(name = "email") String email,
						 @RequestParam(name = "phone") String phone,
						 Model model) 
	{
		Student student = new Student();
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setGender(gender);
		student.setAddress(address);
		student.setCity(city);
		student.setCountry(country);
		student.setZip(zip);
		student.setEmail(email);
		student.setPhone(phone);
		
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
	
	@GetMapping(path = "/edit") 
	public String edit(@RequestParam(name = "id") int id, Model model) {
		
		try {
			Student student = studentService.view(id);
			model.addAttribute("success", true);
			model.addAttribute("student", student);
		} 
		catch (Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return "studentupdate";
	}
	
	@PostMapping(path = "/update")
	public String update(@RequestParam(name = "id") int id,
						 @RequestParam(name = "firstname") String firstname,
						 @RequestParam(name = "lastname") String lastname,
						 @RequestParam(name = "gender") String gender,
						 @RequestParam(name = "address") String address,
						 @RequestParam(name = "city") String city, 
						 @RequestParam(name = "country") String country,
						 @RequestParam(name = "zip") int zip, 
						 @RequestParam(name = "email") String email,
						 @RequestParam(name = "phone") String phone,
						 Model model) 
	{
		model.addAttribute("update", true);
		
		Student student = new Student();
		student.setId(id);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setGender(gender);
		student.setAddress(address);
		student.setCity(city);
		student.setCountry(country);
		student.setZip(zip);
		student.setEmail(email);
		student.setPhone(phone);
		
		try{
			studentService.update(student);
			model.addAttribute("message", "Student successfully updated.");
		}
		catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "studentupdate";
	}
}



