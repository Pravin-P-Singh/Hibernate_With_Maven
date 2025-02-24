package com.tka;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class GetEmployee {
	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {			
			session = sessionFactory.openSession();
			
			//User wants to retrieve single employee as per id
			
			int id = 1;
			Employee employee = session.get(Employee.class,id);
			System.out.println(employee);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
