package com.tka.one_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.tka.mapping.one_to_one.Address;

@Entity
public class Person {
	
	@Id
	private int personId;
	private String personName;
	private int personAge;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	public Person() {
		super();
	}

	public Person(int personId, String personName, int personAge, List<Address> address) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
		this.address = address;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge + ", address="
				+ address + "]";
	}
	
}
