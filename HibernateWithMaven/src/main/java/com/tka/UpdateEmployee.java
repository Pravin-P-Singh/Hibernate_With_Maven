package com.tka;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class UpdateEmployee {
	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {			
			session = sessionFactory.openSession();
			
			//User wants to update specific record
			
			Employee employee = new Employee(2,"cc","HR",70000);
			
			session.update(employee);
			
			//INSERT UPDATE DELETE inme se koi bhi operation chalana hai to 
			//transaction shuru karke commit karna hi padta hai varna query nhi chalti hai 
			//aur database mai permanently store bhi nhi hopayega agar ye beginTransaction() aur commit() nhi kiya toh
			session.beginTransaction().commit();
			System.out.println("Updated");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
