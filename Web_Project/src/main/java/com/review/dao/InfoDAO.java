package com.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.review.DBConnection.DBConnection;
import com.review.Util.Util;

public class InfoDAO {
	private InfoDAO(){
		
	}
	private static InfoDAO instance = new InfoDAO();
		
	public static InfoDAO getInstance() {
		return instance;
	}
	
	
	public ArrayList<HashMap<String, Object>> actionWriteList(String table, String id, int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = DBConnection.dbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT count(*) FROM "+table+" WHERE no=(SELECT no FROM Login WHERE id=?)) AS totalcount, "
				+ "a.* FROM "+table+" a WHERE no=(SELECT no FROM Login WHERE id=?) ORDER BY ano DESC LIMIT ?, 5;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setInt(3, page);
			rs = pstmt.executeQuery();
			//System.out.println(pstmt);
			if(rs != null) {
				list = new ArrayList<HashMap<String,Object>>();
				while(rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("no", rs.getInt("no"));
					map.put("ano", rs.getInt("ano"));
					map.put("atitle", rs.getString("atitle"));
					map.put("acount", rs.getInt("acount"));
					map.put("adate", rs.getDate("adate"));
					map.put("acontent", rs.getString("acontent"));
					map.put("athumbnail", rs.getString("athumbnail"));
					map.put("alike", rs.getInt("alike"));
					map.put("aip", rs.getString("aip"));
					map.put("afilename", rs.getString("afilename"));
					map.put("atable", rs.getString("atable"));
					list.add(map);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Util.closeAll(null, pstmt, conn);
		}
		
		return list;
	}
	
}
