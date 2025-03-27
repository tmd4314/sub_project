package com.project.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Review.Review;


public class ProductJdbc {
	// Connection 생성.
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
		}
		
		// 사용자 이름 조회
		private String getUserName(String userId) {
			Connection conn = getConnect();
			String userName = null;
			String query = "select user_name "
					     + "from   tbl_user "
					     + "where  user_id = ? ";
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					userName = rs.getString("user_name");
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
			return userName;
		}

		
		//상품 정보 조회
		public Product getProductByName(String productName) {
			Connection conn = getConnect();
			String sql ="select product_code, "
					   + "      product_name, "
					   + "      price, "
					   + "      quantity "
					   + "from  product "
					   + "where product_name =?";
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, productName);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					Product product = new Product();
					product.setProductCode(rs.getString("product_code"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getInt("price"));
					product.setQuantity(rs.getInt("quantity"));
					return product;
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
			
			return null;
		}
		
		// 등록
		public boolean insert(Product product, String userId) {
			String userName = getUserName(userId);
			if(userName == null) {
				System.out.println("사용자를 찾을수 없습니다.");
				return false;
			}
			Connection conn = getConnect();
			String insert = "insert into product(product_code, "
					     + "                    product_name, "
					     + "                    price, "
					     + "                    user_id, "
					     + "                    write_date) "
					     + "values(?,"
					     + "       ?,"
					     + "       ?,"
					     + "       ?,"
					     + "       current_timestamp)";
			try {
				PreparedStatement stmt = conn.prepareStatement(insert);
				stmt.setString(1, product.getProductCode());
				stmt.setString(2, product.getProductName());
				stmt.setInt(3, product.getPrice());
				stmt.setString(4, userName);
				int r = stmt.executeUpdate();
				if( r > 0) {
					return true;
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
			return false;
		}
		
		// 수정
		public boolean update(Product product) {
			Connection conn = getConnect();
			String update = "update product "
					       + "set   product_name =  nvl(?, product_name), "
					       +"       price =  nvl(?, price),"
					       + "      view_cnt = 0 "
					       +" where  product_code = ?";
			try {
				PreparedStatement stmt = conn.prepareStatement(update);
				stmt.setString(1, product.getProductName());
				stmt.setInt(2, product.getPrice());
				stmt.setString(3, product.getProductCode());
				
				int r = stmt.executeUpdate();
				if(r > 0) {
					return true;
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
			return false;
		}
		
		//삭제
		public boolean delete(Product product) {
			Connection conn = getConnect();
			String delete = "delete from product "
					      + "where  product_code = ? ";
			try {
				PreparedStatement stmt = conn.prepareStatement(delete);
				stmt.setString(1, product.getProductCode());
				int r = stmt.executeUpdate();
				if(r > 0) {
					return true;
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
			return false;
		}
		
		
		//입고
		public boolean restock(Product product) {
		    Connection conn = getConnect();
		    String sql = "UPDATE product "
		    		   + "SET    quantity = quantity + ? "
		    		   + "WHERE  product_code = ?";
		    
		    try {
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, product.getQuantity());
		        pstmt.setString(2, product.getProductCode());
		        int r = pstmt.executeUpdate();
		        return r > 0; // 성공적으로 업데이트되었는지 확인
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
		    return false;
		}
		
		//판매(출고)
		public boolean sell(String productName, int quantity) {
			Connection conn = getConnect();
			String sql = "select product_code, "
					   + "       price,"
					   + "       quantity "
					   + "from   product "
					   + "where  product_name = ?";
			
			String updatesql = "UPDATE  product "
					         + "SET     quantity = quantity - ? "
					         + "WHERE   product_code = ?";
			try {
				PreparedStatement cstmt = conn.prepareStatement(sql);
				cstmt.setString(1, productName);
				ResultSet rs = cstmt.executeQuery();
				if(rs.next()) {
					int avquantity = rs.getInt("quantity");
					String productcode = rs.getString("product_code");
					if(avquantity >= quantity) {
						PreparedStatement stmt = conn.prepareStatement(updatesql);
						stmt.setInt(1, quantity);
						stmt.setString(2, productcode);
						int r = stmt.executeUpdate();
						if(r > 0) {
							return true;
						}
					}
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
			return false;
		}
		
		// 목록
		public List<Product> list(int currentPage, int pageSize) {
		    List<Product> productList = new ArrayList<>();
		    Connection conn = getConnect();
		    
		    // 페이징을 위한 SQL 쿼리 (Oracle의 경우)
		    String page = "SELECT product_code, "
		    		     + "       product_name, "
		    		     + "       price, "
		    		     + "       user_id, "
		    		     + "       write_date,"
		    		     + "       quantity "
		    		     + "FROM ( "
		                 + "SELECT a.product_code, "
		                 + "       a.product_name, "
		                 + "       a.price, "
		                 + "       a.user_id, "
		                 + "       a.write_date, "
		                 + "       a.quantity "
		                 + ", ROWNUM rnum FROM ( "
		                 + "SELECT product_code, "
		                 + "       product_name, "
		                 + "       price, "
		                 + "       user_id, "
		                 + "       write_date, "
		                 + "       quantity "
		                 + " FROM product ORDER BY product_code "
		                 + ") a WHERE ROWNUM <= ?) "
		                 + "WHERE rnum > ?";

		    try (PreparedStatement pstmt = conn.prepareStatement(page)) {
		        pstmt.setInt(1, currentPage * pageSize);  // 최대 ROWNUM
		        pstmt.setInt(2, (currentPage - 1) * pageSize);  // 시작 ROWNUM

		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) {
		            Product product = new Product();
		            product.setProductCode(rs.getString("product_code"));
		            product.setProductName(rs.getString("product_name"));
		            product.setPrice(rs.getInt("price"));
		            product.setUserName(rs.getString("user_id"));  // 등록자
		            product.setWriteDate(rs.getString("write_date"));
		            product.setQuantity(rs.getInt("quantity"));
		            productList.add(product);
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
		    return productList;
		}
		
		//조회(상품조회)
		public List<Product> slist(String productName){
			List<Product> slist = new ArrayList<Product>();
			Connection conn = getConnect();
		    
		    // 페이징을 위한 SQL 쿼리 (Oracle의 경우)
		    String page = "SELECT product_code, "
		    		     + "       product_name, "
		    		     + "       price, "
		    		     + "       user_id, "
		    		     + "       write_date "
		    		     + "FROM   product "
		                 + "WHERE  product_name like ?";

		    try (PreparedStatement pstmt = conn.prepareStatement(page)) {
		        pstmt.setString(1, "%" + productName + "%");
		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) {
		            Product product = new Product();
		            product.setProductCode(rs.getString("product_code"));
		            product.setProductName(rs.getString("product_name"));
		            product.setPrice(rs.getInt("price"));
		            product.setUserName(rs.getString("user_id"));  // 등록자
		            product.setWriteDate(rs.getString("write_date"));
		            slist.add(product);
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
			return slist;
		}
		
		//조회(상품 상세 조회)
		public List<Product> ilist(String productCode){
			List<Product> ilist = new ArrayList<Product>();
			Connection conn = getConnect();
			
			String viewcount = "update product "
					         + "set    view_cnt = view_cnt + 1 "
					         + "where  product_code = ?";
			try {
				PreparedStatement vstmt = conn.prepareStatement(viewcount);
				vstmt.setString(1, productCode);
				vstmt.executeUpdate();
			}catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
			String page = "SELECT  p.product_code, "
	    		     + "           p.product_name, "
	    		     + "           p.price, "
	    		     + "           p.user_id, "
	    		     + "           p.write_date, "
	    		     + "           p.view_cnt, "
	    		     + "           p.quantity, "
	    		     + "           r.review_no, "
	    		     + "           r.review_content, "
	    		     + "           r.user_id as reviewer_id "
	    		     + "FROM       product p "
	    		     + "left join  review r "
	    		     + "on         p.product_code = r.product_code "
	                 + "WHERE      p.product_code = ?";

		    try{
		    	PreparedStatement pstmt = conn.prepareStatement(page);
		        pstmt.setString(1, productCode);
		        ResultSet rs = pstmt.executeQuery();
		        Product product = null;
		        while (rs.next()) {
		        	if (product == null) {  // 첫 번째 반복에서만 Product 객체 생성
		                product = new Product();
		                product.setProductCode(rs.getString("product_code"));
		                product.setProductName(rs.getString("product_name"));
		                product.setPrice(rs.getInt("price"));
		                product.setUserName(rs.getString("user_id"));  // 등록자
		                product.setWriteDate(rs.getString("write_date"));
		                product.setViewCnt(rs.getInt("view_cnt"));
		                product.setQuantity(rs.getInt("quantity"));
		            }
		            
		        	String revconte = rs.getString("review_content");
		            if (revconte != null) {
		                Review review = new Review();
		                review.setReno(rs.getInt("review_no"));
		                review.setRevconte(revconte);
		                review.setUserid(rs.getString("reviewer_id")); // 리뷰 작성자
		                product.addReview(review);
		            }
		            
		        }
		        
	            if(product != null) {
	            	ilist.add(product); // 반복문이 끝난 후, 단 한 번만 리스트에 추가
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
			return ilist;
		}
}
