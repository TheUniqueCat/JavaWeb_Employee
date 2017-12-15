package com.salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task2.DBUtil;

public class SalaryDAO {
	public List<Salary> select(int applicantID){
		List<Salary> salary_list = new ArrayList<Salary>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from tb_salary where applicant_id=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Salary salary = new Salary();
				salary.setSalary_id(rs.getInt(1));
				salary.setPost_salary(rs.getFloat(2));
				salary.setAttendance_salary(rs.getFloat(3));
				salary.setBonus(rs.getFloat(4));
				salary.setTotal_salary(rs.getFloat(5));
				salary.setDate(rs.getString(7));
				salary_list.add(salary);
			}
			return salary_list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return null;
	}//select
	
	
	
	
	public Salary select_a_month(int applicantID, String date){
		System.out.println("查询一个月的工资");
		Salary salary = new Salary();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from tb_salary where applicant_id=? and date=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			while(rs.next()){
				salary.setSalary_id(rs.getInt(1));
				salary.setPost_salary(rs.getFloat(2));
				salary.setAttendance_salary(rs.getFloat(3));
				salary.setBonus(rs.getFloat(4));
				salary.setTotal_salary(rs.getFloat(5));
				salary.setDate(rs.getString(7));
			}
			System.out.println(salary);
			return salary;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return null;
	}//select
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int setSalary(Salary new_sal, int applicantID){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int salary_id = 0;
	    String sql="insert into tb_salary (post_salary,attendance_salary,bonus,applicant_id,date) values(?,?,?,?,?)";
	    
	    try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, new_sal.getPost_salary());
			pstmt.setFloat(2, new_sal.getAttendance_salary());
			pstmt.setFloat(3, new_sal.getBonus());
			
			pstmt.setInt(4, applicantID);
			pstmt.setString(5, new_sal.getDate());
			pstmt.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
			try{
				conn.rollback();
			}catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return salary_id;
	}//setSalary
	
	
	
	public int delete(int applicantID){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql="delete from tb_salary where applicant_id=?";
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeUpdate();
			conn.commit();
			return rs;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return 0;
	}
	
	
	
	
	
}
