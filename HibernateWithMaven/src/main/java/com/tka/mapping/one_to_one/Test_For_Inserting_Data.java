package com.tka.mapping.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;

public class Test_For_Inserting_Data {
	public static void main(String[] args) {
		
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		
		try {
			
			session = sf.openSession();
			
			//Saving the student
			
			//Address object
			Address address = new Address(1,"Kharagpur", 421503, "Ambarnath", "Thane", "Maharashtra", "India");
			
			//Student object
			Student student = new Student(101,"Pravin Singh",90000,"pravin130204@gmail.com",address);
			
			session.save(student);
			session.beginTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
	}
}
