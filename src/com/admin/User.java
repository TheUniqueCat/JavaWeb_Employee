package com.admin;

import com.task4.Applicant;

public class User extends Applicant{
	private String name;
	public User() {
		super();
	}
	public User(int applicantId, String applicantEmail,String name) {
		super(applicantId, applicantEmail, null);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
