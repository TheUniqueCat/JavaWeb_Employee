package com.admin;

import com.salary.Salary;
import com.salary.SalaryDAO;


public class SetSalaryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalaryDAO dao = new SalaryDAO();
		Salary new_sal = new Salary();
		new_sal.setPost_salary(4500);
		new_sal.setAttendance_salary(20);
		new_sal.setBonus(80);
		new_sal.setDate("2017/01");
		dao.setSalary(new_sal, 3);
	}

}
