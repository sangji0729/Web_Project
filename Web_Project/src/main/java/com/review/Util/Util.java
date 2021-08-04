package com.review.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Util {
	//ip가져오기
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWORDED-FOR");
		if(ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null) {
			ip = request.getHeader("WL-Proxy-Clinet-IP");
		}
		if(ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip ==  null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		}
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	
	public static int str2Int(String str) {
		//120A 이렇게 들어온다면 120을 리턴해줍니다
		int result = 0;
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				temp += str.charAt(i);
			}
		}
		result = Integer.parseInt(temp);
		return result;
	}
	
	public static int str2Int2(String str) {
		
		try {
			return Integer.parseInt(str);
		}catch(Exception e) {
			return 0;
		}
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String strRe(String str) {
		str = str.replaceAll(">", "&gt;");//html처리
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll("/", "&#47;");
		str = str.replaceAll("\n", "<br>");//엔터키 처리
		return str;
	}
}
