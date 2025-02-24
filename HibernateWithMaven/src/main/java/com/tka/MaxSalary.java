package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class MaxSalary {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		
		try {
			session = sf.openSession();
			
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.setProjection(Projections.max("salary"));
			
			List <Double> maxSalariedEmployee = criteria.list();
			
			if(!maxSalariedEmployee.isEmpty()) {
				double maxSalary = maxSalariedEmployee.get(0);
				System.out.println(maxSalary);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
