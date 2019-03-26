package com.kitri.util;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		
		Random ran = new Random();
		for(int i = 0 ; i <1 ; i++) {
			System.out.println(ran.nextBoolean());
		}
		
		double d = ran.nextDouble();
		System.out.println(d);
		
		int i = ran.nextInt();
		System.out.println(i);
	}
}
