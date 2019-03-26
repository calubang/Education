package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "abcdef";
		byte b[] = str.getBytes();
		int len = b.length;
		for (int i = 0; i < len; i++) {
			System.out.println("b[" + i + "] == " + b[i]);
		}
		
		String str2 = "¾È³çÇÏ¼¼¿ä.";
//		byte b2[] = str2.getBytes();
		byte b2[] = str2.getBytes("utf-8");
		int len2 = b2.length;
		for (int i = 0; i < len2; i++) {
			System.out.println("b2[" + i + "] == " + b2[i]);
		
		}
		
		char c[] = str2.toCharArray();
		len = c.length;
		for(int i = 0 ; i<len ; i++) {
			System.out.println("c[" + i + "] == " + c[i]);
		}
	}
	
}
