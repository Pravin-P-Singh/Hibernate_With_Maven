package com.tka;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class Hb_QueryExample2 {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			//For Retrieving all the columns using HQL
			Query<Employee> query = session.createQuery("FROM Employee WHERE name = :n");
			query.setString("n", "Victor Reed");
			List<Employee> getAllEmployeesHQL = query.list();
			
			for(Employee employee : getAllEmployeesHQL) {
				System.out.println(employee);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
