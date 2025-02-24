package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class LimitInHibernate {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.addOrder(Order.desc("name"));
			criteria.setMaxResults(10);
			
			List<Employee> list = criteria.list();
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
