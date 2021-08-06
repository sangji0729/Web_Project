package com.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.review.DBConnection.DBConnection;
import com.review.Util.Util;

public class LogDAO {

	public static void insertLog(HashMap<String, Object> log) {
		Connection conn = DBConnection.dbConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO Log (log_id, log_target, log_etc, log_ip) VALUES (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)log.get("id"));
			pstmt.setString(2, (String)log.get("target"));
			pstmt.setString(3, (String)log.get("etc"));
			pstmt.setString(4, (String)log.get("ip"));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Util.closeAll(null, pstmt, conn);
		}
		
	}

}
