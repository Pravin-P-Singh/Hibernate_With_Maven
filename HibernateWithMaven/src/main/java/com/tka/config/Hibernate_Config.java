package com.tka.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Employee;

public class Hibernate_Config {
	
	public static SessionFactory getSessionFactory() {
		
		SessionFactory sessionFactory = null;
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		
		sessionFactory = cfg.buildSessionFactory();
		
		return sessionFactory;
	}
}
