package com.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static final String USERNAME = "root";
	public static final String PWD="admin";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/test";
	public static final String DRIVER="com.mysql.jdbc.Driver";

	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
	
	
	public static  void closeJDBC(Connection con,Statement st, ResultSet rs)
	{
		
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(st!=null)
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
