package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class MaxSalariedEmployee {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			
			Criteria criteria1 = session.createCriteria(Employee.class);
			criteria1.setProjection(Projections.max("salary"));
			List <Double> maxSalary = criteria1.list();
			System.out.println(maxSalary);
			double maximumSalary=0;
			if(!maxSalary.isEmpty()) {
				maximumSalary = maxSalary.get(0);
				Criteria criteria2 = session.createCriteria(Employee.class);
				criteria2.add(Restrictions.eq("salary",maximumSalary));
				List <Employee> maxSalariedEmployee = criteria2.list();
				
				for(Employee employee : maxSalariedEmployee) {
					System.out.println(employee);
				}
			}
			else {
				System.out.println("No record found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
