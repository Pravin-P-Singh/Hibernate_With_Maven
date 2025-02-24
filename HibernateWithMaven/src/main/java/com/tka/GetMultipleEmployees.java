package com.tka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GetMultipleEmployees {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("How many employees you want to fetch");
			int employeeCount = scanner.nextInt();
			List<Integer> employeeIds = new ArrayList<Integer>();
			for(int i = 1; i <= employeeCount; i++) {
				System.out.println("Enter id "+i+" : ");
				int employeeId = scanner.nextInt();
				employeeIds.add(employeeId);
			}
			session = sf.openSession();
			List<Employee> employees = session.byMultipleIds(Employee.class).multiLoad(employeeIds);
			System.out.println(employees);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
