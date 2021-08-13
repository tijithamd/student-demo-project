package com.student.project.Repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.project.dataobjects.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Student view(int id) {
		
		Session session = this.sessionFactory.openSession();
		
		Query<Student> query = session.createQuery("Select s from Student s where s.id = :id");
		query.setParameter("id", id);
		return query.uniqueResult();
	}
	
	public List<Student> viewall() {
		
		Session session = this.sessionFactory.openSession();
		
		Query<Student> query = session.createQuery("Select s from Student s");
		return query.list();
	}
	
	public Student create(Student student) {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		
		return student;
	}
	
	public Student update(Student student) {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		
		return student;
	}
}
