package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class OrderInCriteria {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			
			criteria.addOrder(Order.asc("name")); //desc mai jo name hai property ka inside of the class we have to give that name itself we don't have to look for that name stored inside of the database;
			List<Employee>list = criteria.list();
			
			System.out.println();
			for(Employee employee : list) {
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
