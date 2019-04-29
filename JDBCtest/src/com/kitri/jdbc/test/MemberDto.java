package com.kitri.jdbc.test;

public class MemberDto {
	private int no;
	private String name;
	private String id;
	private String joinDate;
	
	public MemberDto() {
		super();
	}
	public MemberDto(int no, String name, String id, String joinDate) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.joinDate = joinDate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", name=" + name + ", id=" + id + ", joinDate=" + joinDate + "]";
	}
}
