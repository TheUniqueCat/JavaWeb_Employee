package com.salary;

public class Salary {
	private int salary_id;
	private float post_salary;
	private float attendance_salary;
	private float bonus;
	private float total_salary;
	private String date;
	
	
	public int getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}
	public float getPost_salary() {
		return post_salary;
	}
	public void setPost_salary(float post_salary) {
		this.post_salary = post_salary;
	}
	public float getAttendance_salary() {
		return attendance_salary;
	}
	public void setAttendance_salary(float attendance_salary) {
		this.attendance_salary = attendance_salary;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getTotal_salary() {
		return total_salary;
	}
	public void setTotal_salary(float total_salary) {
		this.total_salary = total_salary;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Salary [salary_id=" + salary_id + ", post_salary=" + post_salary + ", attendance_salary="
				+ attendance_salary + ", bonus=" + bonus + ", total_salary=" + total_salary + ", date=" + date + "]";
	}
	public Salary(int salary_id, float post_salary, float attendance_salary, float bonus, float total_salary,
			String date) {
		super();
		this.salary_id = salary_id;
		this.post_salary = post_salary;
		this.attendance_salary = attendance_salary;
		this.bonus = bonus;
		this.total_salary = total_salary;
		this.date = date;
	}
	public Salary(float post_salary, float attendance_salary, float bonus, String date) {
		super();
		this.post_salary = post_salary;
		this.attendance_salary = attendance_salary;
		this.bonus = bonus;
		this.date = date;
	}

	
	
	
	
	
	

}
