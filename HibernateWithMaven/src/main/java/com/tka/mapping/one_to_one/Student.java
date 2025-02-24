package com.tka.mapping.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	private int studentScholarship;
	private String studentEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address studentAddress;
	
	public Student() {
		super();
	}

	public Student(int studentId, String studentName, int studentScholarship, String studentEmail, Address studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScholarship = studentScholarship;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentScholarship() {
		return studentScholarship;
	}

	public void setStudentScholarship(int studentScholarship) {
		this.studentScholarship = studentScholarship;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentScholarship="
				+ studentScholarship + ", studentEmail=" + studentEmail + ", studentAddress=" + studentAddress + "]";
	}
	
}
