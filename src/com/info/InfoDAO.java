package com.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.task2.DBUtil;
import com.task3.ResumeBasicinfo;


public class InfoDAO {
	
	public int addInfo(InfoBasicinfo info, int applicantID) {
		/*
		 * 添加个人简历
		 */
		int infoID = 0;
		String sql = "insert into tb_info_basicinfo(age, job, experience, applicant_id)"
		+"values(?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getAge());
			pstmt.setString(2, info.getJob());
			pstmt.setString(3, info.getExperience());
			pstmt.setInt(4, applicantID);
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
		return infoID;
	}//addInfo
	
	
	public int updaterInfo(InfoBasicinfo info, int applicantID){
		/*
		 * 更新个人简历
		 */
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update tb_info_basicinfo set age=?,job=?,experience=? where applicant_id=?";
		int rs = 0;
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getAge());
			pstmt.setString(2, info.getJob());
			pstmt.setString(3, info.getExperience());
			pstmt.setInt(4, applicantID);
			rs = pstmt.executeUpdate();
			conn.commit();
			System.out.println("result="+rs);
			return applicantID;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return 0;
	}//updaterInfo
	
	public InfoBasicinfo select(int applicantID){
		/*
		 * 查询个人简历
		 */
		InfoBasicinfo info = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from tb_info_basicinfo where applicant_id=?";
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				info = new InfoBasicinfo();
				info.setInfoId(rs.getInt(1));
				info.setAge(rs.getInt(2));
				info.setJob(rs.getString(3));
				info.setExperience(rs.getString(4));
			}
			return info;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return null;
	}
	
	
	public int delete(int applicantID){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql="delete from tb_info_basicinfo where applicant_id=?";
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
