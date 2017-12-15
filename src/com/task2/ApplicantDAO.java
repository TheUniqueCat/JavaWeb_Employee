package com.task2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.User;
import com.info.InfoBasicinfo;
import com.task4.Applicant;


public class ApplicantDAO {
	
	/*
	 * 验证邮箱是否已被注册
	 */
	@SuppressWarnings("null")
	public boolean isExistEmail(String email) {
		Connection conn = DBUtil.getConnection();
		System.out.println("已经链接sql");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_applicant where applicant_email = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next())
				return true;			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, rs);			
		}
		return false;
	}

	
	/*
	 * 保存注册信息
	 */
	public void save(String email, String password) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into tb_applicant(applicant_email, applicant_pwd)"
				+ "values(?,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			pstmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(conn, pstmt, null);
		}

	}


	public int login(String email, String password) {
		// TODO Auto-generated method stub
		int applicantID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select applicant_id from tb_applicant where applicant_email = ? and applicant_pwd = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if(rs.next()){
				applicantID = rs.getInt("applicant_id");
				System.out.println("用户:"+email+"登录成功");
			}
				
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(conn, pstmt, rs);
		}
		
		if(applicantID == 0){
		//用户存在但是密码输入错误
		Connection conn1 = DBUtil.getConnection();
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		String sql1 = "select applicant_id from tb_applicant where applicant_email = ?";
		try {
			pstmt1 = conn1.prepareStatement(sql1);
			pstmt1.setString(1, email);
			rs1 = pstmt1.executeQuery();
			
			if(rs1.next()){
				applicantID = -1;
				System.out.println("用户存在但是密码输入错误");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			DBUtil.closeJDBC(conn1, pstmt1, rs1);
		}
		}
		//用户不存在 返回0 提示注册
		return applicantID;
	}
	
	/*
	 * 判断简历是否存在
	 */
	public int isExistResume(int applicantID) {
		int resumeID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select basicinfo_id from tb_resume_basicinfo where applicant_id = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			if(rs.next())
				resumeID = rs.getInt(1);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(conn, pstmt, rs);
		}
		return resumeID;
	}
	
	
	
	
	public List<User> selectAll(){
		List<User> list = new ArrayList<User>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * "
				+ "from tb_applicant,tb_resume_basicinfo where tb_resume_basicinfo.applicant_id = tb_applicant.applicant_id";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setApplicantId(rs.getInt(1));
				user.setApplicantEmail(rs.getString(2));
				user.setName(rs.getString("name"));
				list.add(user);
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

	public List<User> selectById(int applicantID) {
		List<User> list = new ArrayList<User>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from tb_applicant,tb_resume_basicinfo where tb_resume_basicinfo.applicant_id = tb_applicant.applicant_id and tb_applicant.applicant_id=?";
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setApplicantId(rs.getInt(1));
				user.setApplicantEmail(rs.getString(2));
				user.setName(rs.getString("name"));
				list.add(user);
			}
			return list;
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
		String sql="delete from tb_applicant where applicant_id=?";
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
