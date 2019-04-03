package com.kitri.util.jcf;

public class PlayerDto {
	private int number;
	private String name;
	private int position;
	private double grade;
	private String positionName[] = {"지명타자", "투수", "포수", "1루수", "2루수", "3루수", "유격수", "좌익수", "중견수", "우익수"};
	private String gradeName[] = {"타   율", "방어율"};
	
	public PlayerDto(int number, String name, int position, double grade) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.grade = grade;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return positionName[this.position];
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getGradeName() {
		if(position == 1) {
			return gradeName[position];
		}
		return gradeName[0];
	}

	@Override
	public String toString() {
		return "PlayerDto [등번호=" + getNumber() + "\t선수명=" + getName() + " \t포지션=" 
				+ String.format("%-5s", getPosition()) + "\t" + getGradeName() + "=" +  + getGrade() + "]";
	}
	
	
}
