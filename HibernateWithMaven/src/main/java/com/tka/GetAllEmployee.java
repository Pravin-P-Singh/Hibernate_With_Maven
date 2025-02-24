package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class GetAllEmployee {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			
			List<Employee> list = criteria.list(); //select * from employee
			System.out.println();
			for(Employee employee: list) {
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
