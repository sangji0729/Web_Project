package com.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.review.DBConnection.DBConnection;
import com.review.Util.Util;

public class ActionBoardDAO {
	
	private ActionBoardDAO() {
		
	}
	private static ActionBoardDAO instance = new ActionBoardDAO();
	public static ActionBoardDAO getInstance() {
		return instance;
	}
	
	public ArrayList<HashMap<String, Object>> boardList(int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = DBConnection.dbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Actionview LIMIT ?, 5;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<HashMap<String,Object>>();
				while(rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("commentcount", rs.getInt("commentcount"));
					map.put("ano", rs.getInt("ano"));
					map.put("atitle", rs.getString("atitle"));
					map.put("acontent", rs.getString("acontent"));
					map.put("athumbnail", rs.getString("athumbnail"));
					map.put("adate", rs.getDate("adate"));
					map.put("aip", rs.getString("aip"));
					map.put("acount", rs.getInt("acount"));
					map.put("no", rs.getInt("no"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
					
					list.add(map);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Util.closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public int write(HashMap<String, Object> map) {
		int result = 0;
		Connection conn = DBConnection.dbConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO Action (atitle, acontent, aip, afilename, athumbnail, no) VALUES (?, ?, ?, ?, ?, (SELECT no FROM Login WHERE id=?))";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)map.get("title"));
			pstmt.setString(2, (String)map.get("content"));
			pstmt.setString(3, (String)map.get("ip"));
			pstmt.setString(4, (String)map.get("saveFile"));
			pstmt.setString(5, (String)map.get("thumbnail"));
			pstmt.setString(6, (String)map.get("id"));
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Util.closeAll(null, pstmt, conn);
		}
		
		return result;
	}

	public HashMap<String, Object> detail(int ano) {
		HashMap<String, Object> map = null;
		Connection conn = DBConnection.dbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Actionview WHERE ano=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);
			rs = pstmt.executeQuery();
			if(rs != null) {
				map = new HashMap<String, Object>();
				while(rs.next()) {
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("commentcount", rs.getInt("commentcount"));
					map.put("ano", rs.getInt("ano"));
					map.put("atitle", rs.getString("atitle"));
					map.put("acontent", rs.getString("acontent"));
					map.put("athumbnail", rs.getString("athumbnail"));
					map.put("adate", rs.getDate("adate"));
					map.put("aip", rs.getString("aip"));
					map.put("acount", rs.getInt("acount"));
					map.put("afilename", rs.getString("afilename"));
					map.put("no", rs.getInt("no"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Util.closeAll(rs, pstmt, conn);
		}
		
		return map;
	}

	public ArrayList<HashMap<String, Object>> commentList(int ano) {
		ArrayList<HashMap<String, Object>> commentList = null;
		Connection conn = DBConnection.dbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ActionCommentView WHERE ano=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				commentList = new ArrayList<HashMap<String,Object>>();
				while(rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("acno", rs.getInt("acno"));
					map.put("ano", rs.getInt("ano"));
					map.put("no", rs.getInt("no"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
					map.put("accontent", rs.getString("accontent"));
					map.put("acdate", rs.getDate("acdate"));
					map.put("acip", rs.getString("acip"));
					commentList.add(map);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Util.closeAll(rs, pstmt, conn);
		}
		
		return commentList;
	}
	
}
