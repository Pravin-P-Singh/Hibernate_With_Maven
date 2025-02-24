package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class EmployeesAsPerPattern {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			String pattern = "D";
			/*For employee names starting and ending with a specific letter*/
			String startsWith = "D";
			String endsWith="Z";
			
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.like("name", startsWith+"%"+endsWith));
			
			List<Employee> employeesMatchingPattern = criteria.list();
			
			for(Employee employee : employeesMatchingPattern) {
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
