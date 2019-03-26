package com.kitri.test;

import java.util.ArrayList;
import java.util.List;

import com.kitri.car.Car;

public class CarUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("쏘나타", "검정색", "현대");
		List list = new ArrayList<String>();
		
		System.out.println(String.format("%-6s", "이름")+ ": " + car.getName());
		System.out.println(String.format("%-6s", "색상")+ ": " + car.getColor());
		System.out.println(String.format("%-4s", "제조사")+ ": " + car.getMaker());
		System.out.println(car);
	}

}
