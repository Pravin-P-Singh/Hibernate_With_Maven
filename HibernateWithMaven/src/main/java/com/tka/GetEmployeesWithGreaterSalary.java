package com.tka;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class GetEmployeesWithGreaterSalary {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the salary : ");
			double salary = sc.nextDouble();
			
			criteria.add(Restrictions.gt("salary", salary));
			List<Employee> employeesWithGreaterSalary = criteria.list();
			
			for(Employee employee : employeesWithGreaterSalary) {
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
