package com.tka.one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.Hibernate_Config;
import com.tka.mapping.one_to_one.Address;

public class Test_Insertion_Record_Person {
	public static void main(String[] args) {
		
		SessionFactory sf = Hibernate_Config.getSessionFactory();
		Session session = null;
		
		try {
			
			session = sf.openSession();
			
			//Multiple Addresses
			Address address1 = new Address(2,"Kurla",412901,"Geovrai","Thane","MH","IND");
			Address address2 = new Address(3,"Badlapur",412503,"Ambarnath","Thane","MH","IND");
			List<Address> addressList = new ArrayList<Address>();
			addressList.add(address1);
			addressList.add(address2);
			
			//Person 
			Person person = new Person(101,"Pravin Singh",21,addressList);
			
			session.save(person);
			session.beginTransaction().commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
