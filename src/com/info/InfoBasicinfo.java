package com.info;

public class InfoBasicinfo {
	private int infoId;
	
	private int age;
	
	private String job;
	
	private String experience;
	
	
	

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public InfoBasicinfo(int age, String job, String experience) {
		super();
		this.age = age;
		this.job = job;
		this.experience = experience;
	}

	public InfoBasicinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InfoBasicinfo [infoId=" + infoId + ", age=" + age + ", job=" + job + ", experience=" + experience + "]";
	}
	
	
	
	


}
