package com.student.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.project.Repositories.StudentRepository;
import com.student.project.dataobjects.Student;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository;
	
	public Student view(int id) throws Exception {
		
		Student s = studentRepository.view(id);
		
		if(s == null) {
			throw new Exception("No Student found for given Id [ " + id + " ]");
		}
		return s;
	}
	
	public List<Student> viewAll() {
		List<Student> students = studentRepository.viewall();
		return students;
	}
	
	public Student create(Student student) {
		student.setCreatedTime(new Date());
		student.setLastUpdatedTime(new Date());
		return studentRepository.create(student);
	}
	
	public Student update(Student student) {
		student.setLastUpdatedTime(new Date());
		return studentRepository.update(student);
	}
	
}
