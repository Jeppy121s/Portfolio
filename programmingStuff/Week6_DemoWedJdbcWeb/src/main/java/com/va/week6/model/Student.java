package com.va.week6.model;

import java.sql.Date;

/*
 * @author - each teammeber who wrote this has to write this..
 * @date -
 * Description - This is model class for student.. has firstname...
 * 
 */

public class Student {

	private String firstname;
	private String lastname;
	private String grade;
	//private Date dt; 

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getGrade() {
		return grade;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
