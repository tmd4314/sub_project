package com.project.Product;

import java.util.ArrayList;
import java.util.List;

import com.project.Review.Review;

public class Product {
	private String productCode;
	private String productName;
	private int price;
	private String userName;
	private String writeDate;
	private int viewCnt;
	private int quantity;
	private List<Review> reviews;
	
	public Product(String productCode, String productName, int price, String userName, String writeDate, int viewCnt, int quantity) {
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.userName = userName;
		this.writeDate = writeDate;
		this.viewCnt = viewCnt;
		this.quantity  = quantity ;
	}
	public Product() {
		reviews = new ArrayList<>();
	}
	public void addReview(Review review) {
        reviews.add(review); // 리뷰 추가
    }
	public List<Review> getReviews() {
        return reviews;
    }
	public String showList() {
		String datePart = writeDate.split(" ")[0];
		return productCode + " " + productName + " " + userName + " " + datePart;
	}
	public String showListInfo() {
		String datePart = writeDate.split(" ")[0];
		String stock = quantity == 0 ? "(매진)" : quantity +"개";
		StringBuilder reviewList = new StringBuilder();
		for(Review review :reviews) {
			reviewList.append(review.showListInfo()).append("\n"); // 각 리뷰의 정보를 추가
		}
		return "상품코드: " + productCode + "        "+ "상품명: " + productName + "\n" + "가격:" + " " + price + "원" + "      " + "  " + "등록자: " + userName
				+ "\n" + "등록일자: " + datePart + "  조회수:"+ viewCnt + "\n"
				+"수량: " + stock +"\n"
				+ "=============== 리뷰 ================" + "\n" 
				+"목록      " + "리뷰내용      " + "작성자" +"\n"
				+ reviewList.toString();
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getQuantity () {
		return quantity ;
	}
	public void setQuantity (int quantity ) {
		this.quantity  = quantity ;
	}
}
