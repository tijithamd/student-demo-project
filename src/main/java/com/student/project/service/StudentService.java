package com.student.project.service;

import java.util.Date;

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
	
	public Student create(Student student) {
		student.setCreatedTime(new Date());
		student.setLastUpdatedTime(new Date());
		return studentRepository.create(student);
	}
}
