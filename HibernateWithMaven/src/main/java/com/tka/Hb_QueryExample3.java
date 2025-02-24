package com.tka;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import com.tka.config.Hibernate_Config;
import com.tka.entity.Employee;

public class Hb_QueryExample3 {
	public static void main(String[] args) {
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			//For Retrieving all records with the specified columns using HQL
			Query query1 = session.createQuery("SELECT name,salary FROM Employee");
			List<Object[]> list1 = query1.list();
			
			for(Object[] employee : list1) {
				System.out.print(employee[0]+"\t\t");
				System.out.println(employee[1]);
			}
			
			
			//Jab sirf ek hi column hai tab ya to "Object" ya to us column ke corresponding wrapper class(here String)
			//use kar sakte hai
			Query query2 = session.createQuery("SELECT name FROM Employee");
			List <String> list2 = query2.list();
			
			for (String name : list2) {
				System.out.println(name+"\t\t");
			}
			
			//Jab columns ke dataType same hai tab mai same Wrapper class de sakta hu , here it is String because
			//name and department both column holds String values
			Query query3 = session.createQuery("SELECT name,department FROM Employee");
			List<Object [] > list3 = query3.list();
			for (Object[] value : list3) {
				System.out.println((String)value[0]+"\t\t"+(String)value[1]);
			}
			
			
			//Alternative than HQL
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.setProjection(Projections.property("name"));
			List<String> list = criteria.list(); // This will not return list of employees instead it will return a list of String values
			for (String employeeName : list) {
				System.out.println(employeeName);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
