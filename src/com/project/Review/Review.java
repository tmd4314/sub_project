package com.project.Review;

public class Review {
	int reno;
	String procode;
	String revconte;
	String userid;
	
	public Review() {}
	public Review(int reno, String procode, String revconte, String userid) {
		this.reno = reno;
		this.procode = procode;
		this.revconte = revconte;
		this.userid = userid;
	}
	
	
	public String showListInfo() {
		return reno  +" "+ revconte + " "  + userid;
	}
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public String getProcode() {
		return procode;
	}
	public void setProcode(String procode) {
		this.procode = procode;
	}
	public String getRevconte() {
		return revconte;
	}
	public void setRevconte(String revconte) {
		this.revconte = revconte;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
