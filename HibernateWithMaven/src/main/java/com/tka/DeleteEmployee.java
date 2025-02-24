package com.tka;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class DeleteEmployee {
	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {			
			session = sessionFactory.openSession();
			
			//User wants to delete specific employee as per id
			
			int id = 3;
			Employee employee = session.get(Employee.class,id);
			
			session.delete(employee);
			
			//INSERT UPDATE DELETE inme se koi bhi operation chalana hai to 
			//transaction shuru karke commit karna hi padta hai varna query nhi chalti hai 
			//aur database mai permanently store bhi nhi hopayega agar ye beginTransaction() aur commit() nhi kiya toh
			session.beginTransaction().commit();
			System.out.println("Deleted");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
