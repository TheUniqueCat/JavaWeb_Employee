package com.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task2.DBUtil;

public class MessageDAO {
	
	public void addMessage(Message message, int notice_id, int applicantID){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into tb_message(message_content, notice_id, applicant_id) values(?,?,?)";
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getMessage_content());
			pstmt.setInt(2, notice_id);
			pstmt.setInt(3, applicantID);
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
	}
	
	public List<Message> selectAll(int notice_id){
		List<Message> list = new ArrayList<Message>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from tb_message where notice_id = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Message me = new Message();
				me.setMessage_id(rs.getInt("message_id"));
				me.setMessage_content(rs.getString("message_content"));
				me.setNotice_id(rs.getInt("notice_id"));
				me.setApplicant_id(rs.getInt("applicant_id"));
				list.add(me);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(conn, pstmt, rs);
		}
		return null;
	}
	
	public int delete(int message_id){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql="delete from tb_message where message_id=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message_id);
			rs = pstmt.executeUpdate();
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
