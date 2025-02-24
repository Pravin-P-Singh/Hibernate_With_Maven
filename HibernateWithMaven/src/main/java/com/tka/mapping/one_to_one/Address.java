package com.tka.mapping.one_to_one;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	private int addressID;
	private String village;
	private int pincode;
	private String taluka;
	private String district;
	private String state;
	private String country;
	
	public Address() {
		super();
	}

	public Address(int addressID,String village, int pincode, String taluka, String district, String state, String country) {
		super();
		this.addressID = addressID;
		this.village = village;
		this.pincode = pincode;
		this.taluka = taluka;
		this.district = district;
		this.state = state;
		this.country = country;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [village=" + village + ", pincode=" + pincode + ", taluka=" + taluka + ", district=" + district
				+ ", state=" + state + ", country=" + country + "]";
	}
	
	
}
