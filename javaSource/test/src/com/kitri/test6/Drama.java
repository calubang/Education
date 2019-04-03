package com.kitri.test6;

public class Drama extends TVProgram {
	private String director;
	private String actor;
	private String actress;
	
	//������
	public Drama(String title, String broadcase, String director) {
		this(title, broadcase, director, "", "");
	}
	public Drama(String title, String broadcase, String director, String actor, String actress) {
		super(title, broadcase);
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	
	@Override
	public String toString() {
		String info = super.toString();
		if( !getDirector().isEmpty()) {
			info += "\n\t - ���� : " + getDirector(); 
		}
		if( !getActor().isEmpty()) {
			info += "\n\t - ���ڹ�� : " + getActor(); 
		}
		if( !getActress().isEmpty()) {
			info += "\n\t - ���ڹ�� : " + getActress(); 
		}
		return info;	
	}
}
