package com.info;

public class InfoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfoDAO dao = new InfoDAO();
		InfoBasicinfo info = new InfoBasicinfo(25, "IOS", "Two to three years");
		dao.addInfo(info, 4);
		
	}

}
