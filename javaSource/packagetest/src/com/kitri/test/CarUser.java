package com.kitri.test;

import java.util.ArrayList;
import java.util.List;

import com.kitri.car.Car;

public class CarUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("�Ÿ", "������", "����");
		List list = new ArrayList<String>();
		
		System.out.println(String.format("%-6s", "�̸�")+ ": " + car.getName());
		System.out.println(String.format("%-6s", "����")+ ": " + car.getColor());
		System.out.println(String.format("%-4s", "������")+ ": " + car.getMaker());
		System.out.println(car);
	}

}
