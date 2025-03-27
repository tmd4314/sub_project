package com.project.Resident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResidentJdbc {
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} //end of getConnect.
	
	//관리자 로그인
	public Resident relogin(String id, String pw) {
		Connection conn = getConnect();
		String sql = "select residentr_id, "
				   + "       resident_pw, "
				   + "       resident_name "
				   + "from   resident "
				   + "where  residentr_id = ? "
				   + "  and  resident_pw = ? ";
		try {
			PreparedStatement resmt = conn.prepareStatement(sql);
			resmt.setString(1, id);
			resmt.setString(2, pw);
			ResultSet ls = resmt.executeQuery();
			if(ls.next()) {
				System.out.println("로그인 성공");
				Resident resident = new Resident(ls.getString("residentr_id"), ls.getString("resident_pw"), ls.getString("resident_name"));
				return resident;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return null;
	}
	
	public List<Map<String, String>> residentList(){
		List<Map<String, String>> rlist = new ArrayList<Map<String, String>>();
		Connection conn = getConnect();
		String sql = "select residentr_id, "
				   + "       resident_pw, "
				   + "       resident_name "
				   + "from   resident ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				// userId, password, userName 저장할 컬렉션.
				Map<String, String> map = new HashMap<String, String>();
				map.put("reId", rs.getString("residentr_id"));
				map.put("rePw", rs.getString("resident_pw"));
				map.put("reName", rs.getString("resident_name"));
				rlist.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return rlist;
	}
}
