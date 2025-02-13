package com.tka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class Test {
	public static void main(String[] args) {
		Employee employee = new Employee(1,"aa","HR",40000);
		
		SessionFactory sessionFactory = Hibernate_Config.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.save(employee);
		//save,update,delete ye 3 operation ke liye transaction commit karna padega
		session.beginTransaction().commit();
		
		System.out.println("Employee added");
	}
}
