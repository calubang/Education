package com.kitri.test5;

public class Car {
	private String color;
	private int account;
	
	//생성자
	public Car(String color, int account) {
		super();
		this.color = color;
		this.account = account;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "[색상] " + getColor() + "\t[생산수량] " + getAccount();
	}
	
	
	
	
}
