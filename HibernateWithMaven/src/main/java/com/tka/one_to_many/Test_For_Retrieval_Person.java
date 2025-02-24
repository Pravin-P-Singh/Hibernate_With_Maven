package com.tka.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;

public class Test_For_Retrieval_Person {
	public static void main(String[] args) {
		
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		
		try {
			
			session = sf.openSession();
			
			Person person = session.get(Person.class, 101);
			
			System.out.println(person);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
