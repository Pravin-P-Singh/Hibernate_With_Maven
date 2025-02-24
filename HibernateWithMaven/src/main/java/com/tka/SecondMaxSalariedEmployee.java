package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class SecondMaxSalariedEmployee {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			
			//My Way
			//Criteria for getting max salary
			/*Criteria criteria1 = session.createCriteria(Employee.class);
			criteria1.setProjection(Projections.max("salary"));
			List<Double> descendingSalaryListOfEmployees=criteria1.list();
			double maxSalary = descendingSalaryListOfEmployees.get(0);
			
			//Criteria for getting the secondMax salary
			Criteria criteria2 = session.createCriteria(Employee.class);
			criteria2.add(Restrictions.ne("salary", maxSalary));
			criteria2.setProjection(Projections.max("salary"));
			//agar kabhi bhi projection use karliya hai criteria ke upar bhale uske age piche kuch bhi ho, final result hamesha ek aggregate value hi milega aur uska returnType column ke dataType ka hoga jispe aggregate function lagaya hai
			List <Double> secondMaxSalariedEmployee = criteria2.list();
			double secondMaxSalary = secondMaxSalariedEmployee.get(0);
			
			//Criteria for displaying the employee with the second highest salary
			Criteria criteria3 = session.createCriteria(Employee.class);
			criteria3.add(Restrictions.eq("salary",secondMaxSalary));
			List <Employee> secondMostSalariedEmployee = criteria3.list();
			
			for (Employee employee : secondMostSalariedEmployee) {
				System.out.println(employee);
			}
			*/
			
			//Sir's Way
			Criteria criteria1 = session.createCriteria(Employee.class);
			criteria1.setProjection(Projections.max("salary"));
			List<Double>maxSalary = criteria1.list();
			
			if(!maxSalary.isEmpty()) {
				
				Criteria criteria2 = session.createCriteria(Employee.class);
				criteria2.add(Restrictions.lt("salary", maxSalary.get(0)));
				criteria2.setProjection(Projections.max("salary"));
				
				List<Double> secondMaxSalary = criteria2.list();
				double secondMaxSalaryValue = secondMaxSalary.get(0);
				
				Criteria criteria3 = session.createCriteria(Employee.class);
				criteria3.add(Restrictions.eq("salary", secondMaxSalaryValue));
				List <Employee> employeeWithSecondHighestSalary = criteria3.list();
				
				for(Employee employee : employeeWithSecondHighestSalary) {
					System.out.println(employee);
				}
				
			} else {
				System.out.println("Record not found");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
