package com.project.Resident;

public class Resident {
	private String reId;
	private String rePw;
	private String reName;
	
	public Resident() {}
	public Resident(String reId, String rePw, String reName) {
		this.reId = reId;
		this.rePw = rePw;
		this.reName = reName;
	}
	public String getReId() {
		return reId;
	}
	public void setReId(String reId) {
		this.reId = reId;
	}
	public String getRePw() {
		return rePw;
	}
	public void setRePw(String rePw) {
		this.rePw = rePw;
	}
	public String getReName() {
		return reName;
	}
	public void setReName(String reName) {
		this.reName = reName;
	}
}
