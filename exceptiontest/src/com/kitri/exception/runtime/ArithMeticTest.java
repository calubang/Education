package com.kitri.exception.runtime;

import java.util.Random;

public class ArithMeticTest {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int x = 30;
		
		//Runtime 은 try 로 처리하지 않고 로직으로 처리한다.
		//int y = random.nextInt(5);
//		try {
//			int z = x/y;
//		
//			System.out.println(x + " / " +  y + " = " + z);
//		
//		} catch(ArithmeticException e) {
//			System.out.println(e.getMessage());
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
		
		//1.
		int y = random.nextInt(5);
		if(y != 0) {
			int z = x/y;
			System.out.println(x + " / " +  y + " = " + z);
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		//2. 
		y = random.nextInt(4)+1;
		int z = x/y;
		System.out.println(x + " / " +  y + " = " + z);

	}

}
