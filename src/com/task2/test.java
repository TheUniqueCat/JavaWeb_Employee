package com.task2;

import java.util.List;

import com.admin.User;


public class test {
	public static void main(String[] args) {
		ApplicantDAO dao = new ApplicantDAO();
		List<User> list = dao.selectAll();
		System.out.println(list.toString());
	}
}
