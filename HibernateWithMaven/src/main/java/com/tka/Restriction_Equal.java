package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class Restriction_Equal {
	public static void main(String[] args) {
		
		//User wants to retrieve the employee whose name is David White
		
		Session session = null;
		try {
			SessionFactory sf = Hibernate_Config.getSessionFactory();
			session = sf.openSession();
			
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("name", "David White"));
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
