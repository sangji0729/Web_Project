package com.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT count(*) FROM "+table+" WHERE no=(SELECT l.no FROM Login l WHERE l.id=?)) AS totalcount, "
				+ "a.no, a.ano, a.atitle, a.acount, a.adate, a.acontent, a.athumbnail, a.alike, a.aip, "
				+ "a.afilename, a.atable, l2.id, l2.name FROM "+table+" a JOIN Login l2 ON a.no = l2.NO "
				+ "WHERE a.no=(SELECT l3.no FROM Login l3 WHERE l3.id=?) ORDER BY a.ano "
				+ "DESC LIMIT ?, 5;";
		
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
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
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


	public ArrayList<HashMap<String, Object>> dailyWriteList(String table, String id, int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT count(*) FROM "+table+" WHERE no=(SELECT l.no FROM Login l WHERE l.id=?)) AS totalcount, "
				+ "da.no, da.dano, da.datitle, da.dacount, da.dadate, da.dacontent, da.dathumbnail, da.dalike, da.daip, "
				+ "da.dafilename, da.datable, l2.id, l2.name FROM "+table+" da JOIN Login l2 ON da.no = l2.NO "
				+ "WHERE da.no=(SELECT l3.no FROM Login l3 WHERE l3.id=?) ORDER BY da.dano "
				+ "DESC LIMIT ?, 5;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setInt(3, page);
			//System.out.println(pstmt);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<HashMap<String,Object>>();
				while(rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("no", rs.getInt("no"));
					map.put("dano", rs.getInt("dano"));
					map.put("datitle", rs.getString("datitle"));
					map.put("dacount", rs.getInt("dacount"));
					map.put("dadate", rs.getDate("dadate"));
					map.put("dacontent", rs.getString("dacontent"));
					map.put("dathumbnail", rs.getString("dathumbnail"));
					map.put("dalike", rs.getInt("dalike"));
					map.put("daip", rs.getString("daip"));
					map.put("dafilename", rs.getString("dafilename"));
					map.put("datable", rs.getString("datable"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
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


	public ArrayList<HashMap<String, Object>> dramaWriteList(String table, String id, int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT count(*) FROM "+table+" WHERE no=(SELECT l.no FROM Login l WHERE l.id=?)) AS totalcount, "
				+ "d.no, d.dno, d.dtitle, d.dcount, d.ddate, d.dcontent, d.dthumbnail, d.dlike, d.dip, "
				+ "d.dtable, l2.id, l2.name FROM "+table+" d JOIN Login l2 ON d.no = l2.NO "
				+ "WHERE d.no=(SELECT l3.no FROM Login l3 WHERE l3.id=?) ORDER BY d.dno "
				+ "DESC LIMIT ?, 5;";
		
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
					map.put("dno", rs.getInt("dno"));
					map.put("dtitle", rs.getString("dtitle"));
					map.put("dcount", rs.getInt("dcount"));
					map.put("ddate", rs.getDate("ddate"));
					map.put("dcontent", rs.getString("dcontent"));
					map.put("dthumbnail", rs.getString("dthumbnail"));
					map.put("dlike", rs.getInt("dlike"));
					map.put("dip", rs.getString("dip"));
					map.put("dtable", rs.getString("dtable"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
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


	public ArrayList<HashMap<String, Object>> fantasyWriteList(String table, String id, int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT (SELECT count(*) FROM "+table+" WHERE no=(SELECT l.no FROM Login l WHERE l.id=?)) AS totalcount, "
				+ "f.no, f.fno, f.ftitle, f.fcount, f.fdate, f.fcontent, f.fthumbnail, f.flike, f.fip, "
				+ "f.ffilename, f.ftable, l2.id, l2.name FROM "+table+" f JOIN Login l2 ON f.no = l2.NO "
				+ "WHERE f.no=(SELECT l3.no FROM Login l3 WHERE l3.id=?) ORDER BY f.fno "
				+ "DESC LIMIT ?, 5;";
		
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
					map.put("fno", rs.getInt("fno"));
					map.put("ftitle", rs.getString("ftitle"));
					map.put("fcount", rs.getInt("fcount"));
					map.put("fdate", rs.getDate("fdate"));
					map.put("fcontent", rs.getString("fcontent"));
					map.put("fthumbnail", rs.getString("fthumbnail"));
					map.put("flike", rs.getInt("flike"));
					map.put("fip", rs.getString("fip"));
					map.put("ffilename", rs.getString("ffilename"));
					map.put("ftable", rs.getString("ftable"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
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


	public ArrayList<HashMap<String, Object>> romanceWriteList(String table, String id, int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT count(*) FROM "+table+" WHERE no=(SELECT l.no FROM Login l WHERE l.id=?)) AS totalcount, "
				+ "r.no, r.rno, r.rtitle, r.rcount, r.rdate, r.rcontent, r.rthumbnail, r.rlike, r.rip, "
				+ "r.rfilename, r.rtable, l2.id, l2.name FROM "+table+" r JOIN Login l2 ON r.no = l2.NO "
				+ "WHERE r.no=(SELECT l3.no FROM Login l3 WHERE l3.id=?) ORDER BY r.rno "
				+ "DESC LIMIT ?, 5;";
		
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
					map.put("rno", rs.getInt("rno"));
					map.put("rtitle", rs.getString("rtitle"));
					map.put("rcount", rs.getInt("rcount"));
					map.put("rdate", rs.getDate("rdate"));
					map.put("rcontent", rs.getString("rcontent"));
					map.put("rthumbnail", rs.getString("rthumbnail"));
					map.put("rlike", rs.getInt("rlike"));
					map.put("rip", rs.getString("rip"));
					map.put("rfilename", rs.getString("rfilename"));
					map.put("rtable", rs.getString("rtable"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
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


	public ArrayList<HashMap<String, Object>> thrillerWriteList(String table, String id, int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT count(*) FROM "+table+" WHERE no=(SELECT l.no FROM Login l WHERE l.id=?)) AS totalcount, "
				+ "t.no, t.tno, t.ttitle, t.tcount, t.tdate, t.tcontent, t.tthumbnail, t.tlike, t.tip, "
				+ "t.tfilename, t.ttable, l2.id, l2.name FROM "+table+" t JOIN Login l2 ON t.no = l2.NO "
				+ "WHERE t.no=(SELECT l3.no FROM Login l3 WHERE l3.id=?) ORDER BY t.tno "
				+ "DESC LIMIT ?, 5;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setInt(3, page);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<HashMap<String,Object>>();
				while(rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("no", rs.getInt("no"));
					map.put("tno", rs.getInt("tno"));
					map.put("ttitle", rs.getString("ttitle"));
					map.put("tcount", rs.getInt("tcount"));
					map.put("tdate", rs.getDate("tdate"));
					map.put("tcontent", rs.getString("tcontent"));
					map.put("tthumbnail", rs.getString("tthumbnail"));
					map.put("tlike", rs.getInt("tlike"));
					map.put("tip", rs.getString("tip"));
					map.put("tfilename", rs.getString("tfilename"));
					map.put("ttable", rs.getString("ttable"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
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
