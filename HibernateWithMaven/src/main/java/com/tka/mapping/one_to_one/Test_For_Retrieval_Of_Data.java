package com.tka.mapping.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;

public class Test_For_Retrieval_Of_Data {
	public static void main(String[] args) {
		
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		
		try {
			session = sf.openSession();
			Student student = session.get(Student.class, 101);
			System.out.println(student);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
