package com.kitri.test6;

public class TVProgram {
	private String title;
	private String broadcase;
	
	//»ý¼ºÀÚ
	public TVProgram(String title, String broadcase) {
		super();
		this.title = title;
		this.broadcase = broadcase;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBroadcase() {
		return broadcase;
	}

	public void setBroadcase(String broadcase) {
		this.broadcase = broadcase;
	}

	@Override
	public String toString() {
		return getTitle() + "\t(" + getBroadcase() + ")";
	}
	
}
