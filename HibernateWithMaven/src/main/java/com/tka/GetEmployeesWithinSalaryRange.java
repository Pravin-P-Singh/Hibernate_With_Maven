package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class GetEmployeesWithinSalaryRange {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = sf.openSession();
		
		try {
			session = sf.openSession();
			double lowestSalary = 70000;
			double highestSalary = 89000;
			
			Criteria criteria = session.createCriteria(Employee.class); 
			criteria.add(Restrictions.between("salary", lowestSalary, highestSalary));
			
			List <Employee> employeesWithinSalaryRange = criteria.list();
			
			for (Employee employee : employeesWithinSalaryRange) {
				System.out.println(employee);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		} finally {
			session.close();
		}
	}
}
