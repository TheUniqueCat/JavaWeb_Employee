package com.task3;


public class ResumeBasicinfo {
	
	private int basicinfoId;
	
	private String name;
	
	private int phone;
	
	private String email;
	
	private String sex;

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}

	public int getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getSex() {
		return sex;
	}
	
	
	

	public int getBasicinfoId() {
		return basicinfoId;
	}

	public void setBasicinfoId(int basicinfoId) {
		this.basicinfoId = basicinfoId;
	}

	public ResumeBasicinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResumeBasicinfo(String name, int phone, String email, String sex) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "ResumeBasicinfo [basicinfoId=" + basicinfoId + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", sex=" + sex + "]";
	}


}
