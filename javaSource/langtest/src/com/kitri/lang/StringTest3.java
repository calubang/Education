package com.kitri.lang;

public class StringTest3 {

	
	public static void main(String[] args) {
		String str = "hello java !!!";
		char c = str.charAt(4);
		System.out.println("c == " + c);
		
		str = "123";
		int x = str.charAt(0) - 48;
		System.out.println("x == " + x);
		
		str = "1a3";
		int len = str.length();
		System.out.println("length == " + len);
		String result = "숫자입니다.";
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				result = "숫자가 아닙니다.";
				break;
			}
		}		
		System.out.println(str + "은 " + result);
		
		String str1 = "hello ";
		String str2 = "java";
		System.out.println(str1 + str2);
		System.out.println(str1.concat(str2));
		
		str = "hello java !!!";
		if(str.startsWith("he"))
			System.out.println(str + "은 he로 시작한다.");
		if(str.endsWith("!!"))
			System.out.println(str + "은 !!로 끝난다.");
		
		String s1 = "jAva";
		String s2 = "JavA";
		System.out.println("s1.toUpperCase() == " + s1.toUpperCase());
		System.out.println("s2.toLowerCase() == " + s2.toLowerCase());
		if(s1.equals(s2))
			System.out.println(s1 + "과 " + s2 + "는 같은문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 다른문자열이다.");
		
		if(s1.toUpperCase().equals(s2.toUpperCase()))
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 같은문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 다른문자열이다.");
		
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 같은문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 다른문자열이다.");
	}
	
}



















