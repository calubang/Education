package com.kitri.lang;

public class StringVSBuffer {
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		String str = "hello";
		for(int i =0 ; i<5000 ; i++) {
			str += i;
		}
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
		startTime = System.nanoTime();
		StringBuffer sb = new StringBuffer("hello");
		for(int i =0 ; i<5000 ; i++) {
			sb.append(i);
		}
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
	}
}
