package com.task3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.User;
import com.task2.DBUtil;

public class ResumeDAO {

	@SuppressWarnings("resource")
	public int add(ResumeBasicinfo basicinfo, int applicantID) {
		// TODO Auto-generated method stub
		int basicinfoID = 0;
		String sql = "insert into tb_resume_basicinfo(name, phone, email, sex, applicant_id)"
		+"values(?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, basicinfo.getName());
			pstmt.setInt(2, basicinfo.getPhone());
			pstmt.setString(3, basicinfo.getEmail());
			pstmt.setString(4, basicinfo.getSex());
			System.out.println("性别："+basicinfo.getSex());
			pstmt.setInt(5, applicantID);
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
		return basicinfoID;
	}
	
	/*
	 * 查询个人信息（By applicantID）
	 */
	
	public ResumeBasicinfo select(int applicantID){
		ResumeBasicinfo resume = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from tb_resume_basicinfo where applicant_id=?";
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				resume = new ResumeBasicinfo();
				resume.setBasicinfoId(rs.getInt(1));
				resume.setName(rs.getString(2));
				resume.setPhone(rs.getInt(3));
				resume.setEmail(rs.getString(4));
				resume.setSex(rs.getString(5));
			}
			return resume;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return null;
	}
	
	public List<ResumeBasicinfo> selectAll(){
		List<ResumeBasicinfo> list = new ArrayList<ResumeBasicinfo>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from tb_resume_basicinfo";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ResumeBasicinfo re = new ResumeBasicinfo();
				re.setName(rs.getString("name"));
				re.setSex(rs.getString("sex"));
				re.setPhone(rs.getInt("phone"));
				list.add(re);
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(conn, pstmt, rs);
		}
		return null;
	}
	
	
	
	
	
	
	

	/*
	 * 更新个人信息
	 */
	public int update(ResumeBasicinfo basicinfo, int applicantID){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update tb_resume_basicinfo set name=?,phone=?,email=?,sex=? where applicant_id=?";
		int rs = 0;
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, basicinfo.getName());
			pstmt.setInt(2, basicinfo.getPhone());
			pstmt.setString(3, basicinfo.getEmail());
			pstmt.setString(4, basicinfo.getSex());
			pstmt.setInt(5, applicantID);
			rs = pstmt.executeUpdate();
			conn.commit();
			System.out.println("result="+rs);
			return rs;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return 0;
	}//update
	
	public int delete(int applicantID){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql="delete from tb_resume_basicinfo where applicant_id=?";
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
