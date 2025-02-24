package com.tka.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Employee;
import com.tka.mapping.one_to_one.Address;
import com.tka.mapping.one_to_one.Student;
import com.tka.one_to_many.Person;

public class Hibernate_Config {
	
	public static SessionFactory getSessionFactory() {
		
		SessionFactory sessionFactory = null;
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).addAnnotatedClass(Person.class);
		
		sessionFactory = cfg.buildSessionFactory();
		
		return sessionFactory;
	}
}
