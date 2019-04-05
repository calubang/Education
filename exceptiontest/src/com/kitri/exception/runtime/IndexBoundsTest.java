package com.kitri.exception.runtime;

public class IndexBoundsTest {
	public static void main(String[] args) {
		
		String s[] = {"1", "2", "3" , "4"};
		
		//배열의 범위를 벗어나는 곳을 참조
		for(int i = 0 ; i<4 ; i++) {
			System.out.println(s[i]);
		}
		
		String str = "hello";
		for(int i =0  ; i<5 ; i++) {
			System.out.println(str.charAt(i));
		}
		
		int len = str.length();
		for(int i =0  ; i<len ; i++) {
			System.out.println(str.charAt(i));
		}
		
		
		
	}
}
