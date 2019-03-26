package com.kitri.array;
//0�� ����Ÿ��
//1 : ����
//2 : ����
//3,4,5 : 1,2,3��� 
//6 : ���ݼ� 
//7 : ���ͼ�
//8 : ���ݼ�
//9 : ���ͼ�
//Ÿ�ڴ� Ÿ��, ������ �����
public class PlayerDto {
	
	private int number;
	private String name;
	private int position;
	private double grade;
	private String positionName[] = {"����Ÿ��", "����", "����", "1���", "2���", "3���", "���ݼ�", "���ͼ�", "�߰߼�", "���ͼ�"};
	private String gradeName[] = {"Ÿ   ��", "�����"};
	
	//������
	public PlayerDto(int number, String name, int position, double grade) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.grade = grade;
	}
	
	//
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
		return "PlayerDto [���ȣ=" + number + "\t������=" + name + " \t������=" 
				+ String.format("%-5s", getPosition()) + "\t" + getGradeName() + "=" +  + grade + "]";
	}
	
	
}
