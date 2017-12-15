package com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.task2.DBUtil;

public class NoticeDAO {
	public void addNotice(Notice notice) {
		/*
		 * 添加通知
		 */
		String sql = "insert into tb_notice(notice_title, notice_content, notice_date)"
		+"values(?,?,?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getNotice_title());
			pstmt.setString(2, notice.getNotice_content());
			pstmt.setString(3, notice.getNotice_date());
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
	}//
	
	public List<Notice> selectAll(){
		List<Notice> list = new ArrayList<Notice>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from tb_notice";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Notice no = new Notice();
				no.setNotice_id(rs.getInt(1));
				no.setNotice_title(rs.getString(2));
				no.setNotice_content(rs.getString(3));
				no.setNotice_date(rs.getString(4));
				list.add(no);
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
	
	public Notice selectByid(int notice_id){
		Notice no = new Notice();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from tb_notice where notice_id = ?";
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				no.setNotice_id(rs.getInt(1));
				no.setNotice_title(rs.getString(2));
				no.setNotice_content(rs.getString(3));
				no.setNotice_date(rs.getString(4));
			}
			return no;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(conn, pstmt, rs);
		}
		return null;
		
	}
	
	public int update(int notice_id){
		NoticeDAO dao = new NoticeDAO();
		Notice no = dao.selectByid(notice_id);
		String title = no.getNotice_title();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update tb_notice set notice_title=? where notice_id=?";
		int rs = 0;
		try{
			conn.setAutoCommit(false);//关闭自动提交
			pstmt = conn.prepareStatement(sql);
			StringBuffer new_title = new StringBuffer("(已删除)");
			pstmt.setString(1, new_title.append(title).toString());
			pstmt.setInt(2, notice_id);
			rs = pstmt.executeUpdate();
			conn.commit();
			return rs;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(conn, pstmt, null);
		}
		return 0;
	}
	
	
	
	
	
	
	
	

}
