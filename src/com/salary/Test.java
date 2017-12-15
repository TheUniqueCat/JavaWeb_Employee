package com.salary;

import com.message.Message;
import com.message.MessageDAO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalaryDAO dao = new SalaryDAO();
		
		System.out.println(dao.select_a_month(3, "2017/07"));
	}

}
