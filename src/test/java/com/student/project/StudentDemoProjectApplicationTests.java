package com.student.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.project.Repositories.StudentRepository;
import com.student.project.dataobjects.Student;
import com.student.project.service.StudentService;

@SpringBootTest
class StudentDemoProjectApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void view() throws Exception {
		Student s = studentService.view(10);
		System.out.println(s);
	}
	
	//@Test
	public void create() {
		Student s = new Student();
		s.setName("Arjun");
		s.setCity("Chennai");
		s.setCountry("India");
		studentService.create(s);
	}
}
