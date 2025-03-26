package com.project.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserJdbc {
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
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
	
	// 회원가입
	public User signup(String id, String pw, String name) {
		Connection conn = getConnect();
		String sql = "insert into tbl_user(user_id, "
				   + "                     user_pw, "
				   + "                     user_name) "
				   + "values (?, "
				   + "        ?, "
				   + "        ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, name);
			int r = stmt.executeUpdate();
			if( r > 0) {
				 return new User(id, pw, name); 
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
		
		return null; //회원가입 실패
	}
	
	//회원 중복 체크
	public boolean isIdUnique(String id) {
	    Connection conn = getConnect();
	    String sql = "SELECT COUNT(*) FROM tbl_user WHERE user_id = ?";
	    
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, id);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            return rs.getInt(1) == 0; // 0이면 중복되지 않음
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
	    
	    return false; // 오류 발생 시 중복 처리
	}
	
	//로그인
	public User login(String id, String pw) {
		Connection conn = getConnect();
		String sql = "select user_id, "
				   + "       user_pw, "
				   + "       user_name "
				   + "from   tbl_user "
				   + "where  user_id = ? "
				   + "  and  user_pw = ? ";
		try {
			PreparedStatement lsmt = conn.prepareStatement(sql);
			lsmt.setString(1, id);
			lsmt.setString(2, pw);
			ResultSet ls = lsmt.executeQuery();
			if(ls.next()) {
				System.out.println("로그인 성공");
				User user = new User(ls.getString("user_id"), ls.getString("user_pw"), ls.getString("user_name"));
				return user;
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
	
	public List<Map<String, String>> userList(){
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection conn = getConnect();
		String sql = "select user_id, "
				   + "       user_pw, "
				   + "       user_name "
				   + "from   tbl_user ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				// userId, password, userName 저장할 컬렉션.
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", rs.getString("user_id"));
				map.put("userPw", rs.getString("user_pw"));
				map.put("userName", rs.getString("user_name"));
				list.add(map);
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
		return list;
	}
}
