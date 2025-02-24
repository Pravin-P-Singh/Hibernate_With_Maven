package com.tka.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class Test_Second_Level_Cache {
	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate_Config.getSessionFactory();
		Session session1 = null;
		Session session2 = null;
		
		try {
			session1 = sessionFactory.openSession();
			session2 = sessionFactory.openSession();
			Employee employee = session1.get(Employee.class, 1);
			System.out.println(employee);
			Employee employee2 = session2.get(Employee.class, 1);
			System.out.println(employee2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session1.close();
			session2.close();
		}
	}
}
