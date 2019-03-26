package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = null;
		str = new String(); // "" 와 동일함~
		System.out.println("문자열 길이 : " + str.length());
		
		//byte b[] = {97, 98, 99, 100};
		byte b[] = {-66, -56, -77, -25, -57, -49, -68, -68, -65, -28, 46};
		String str2 = new String(b);
//		String str2 = new String(b, "euc-kr");
		System.out.println("str2 == " + str2);
		
		
		byte b2[] = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46};
		String str3 = new String(b2, "utf-8");
		System.out.println("str3 == " + str3);
		
		byte b3[] = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4);
		System.out.println("str4 == " + str4);
		
		
//		char c[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		char c[] = {'안', '녕', '하', '세', '요', '.'};
		String str5 = new String(c);
		System.out.println("str5 == " + str5);
		
		String str6 = new String(c, 2, 4);
		System.out.println("str6 == " + str6);
	}
}
