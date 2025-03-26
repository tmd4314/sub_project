package com.project.Review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewJdbc {
	// Connection 생성.
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
	}

	// 리뷰 작성
	public boolean write(Review review, String userid) {
		Connection conn = getConnect();
		String sql = "insert into review(review_no, "
				   + "                   product_code, "
				   + "                   review_content, "
				   + "                   user_id) "
				   + "values (review_seq.NEXTVAL, "
				   + "        ?, "
				   + "        ?, "
				   + "        ?) ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, review.getProcode());
			stmt.setString(2, review.getRevconte());
			stmt.setString(3, userid);
			int r = stmt.executeUpdate();
			if( r > 0) {
				return true;
			}
		}catch (SQLException e) {
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
		return false;
	}
	
	//리뷰 수정(본인 외엔 불가능)
	public boolean modify(Review review, String userid) {
		Connection conn = getConnect();
		String sql = "update review "
				   + "set    review_content = nvl(?, review_content) "
				   + "where  review_no = ? "
				   + " and   user_id = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, review.getRevconte());
			stmt.setInt(2, review.getReno());
			stmt.setString(3, userid);
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch (SQLException e) {
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
		return false;
	}
	
	//리뷰 삭제(본인 외엔 불가능)
	public boolean redelete(Review review, String userid) {
		Connection conn = getConnect();
		String sql = "delete from review "
				   + "where  review_no = ?"
				   + " and   user_id = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, review.getReno());
			stmt.setString(2, userid);
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch (SQLException e) {
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
		return false;
	}
	
	
	
}
