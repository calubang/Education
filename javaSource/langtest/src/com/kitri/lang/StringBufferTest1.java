package com.kitri.lang;

public class StringBufferTest1 {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("hello ");
		
		System.out.println("1. sb == " + sb);
		int cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		
		sb.append("java");
		System.out.println("2. sb == " + sb);
		
		sb.append(" !!!!!");
		System.out.println("3. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
	
		sb.append(" !!!!!!!");
		System.out.println("4. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		
		sb.insert(10, "@@@");
		System.out.println("5. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		
		sb.delete(10, 12);
		System.out.println("6. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		
		sb.deleteCharAt(10);
		System.out.println("7. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		
		sb.replace(6, 10, "자바12345678");
		System.out.println("8. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		
		sb.reverse();
		System.out.println("9. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		sb.reverse();

		sb.setCharAt(9, '@');
		System.out.println("10. sb == " + sb);
		cap = sb.capacity();
		System.out.println("초기 크기 : " + cap + "\t문자열 수 : "+ sb.length());
		sb.reverse();
		
		String s1 = new String(sb);
		String s2 = sb.toString();
		
		String str = "hello 자바 !자바!!";
		String findStr = "자바";
		String findStr2 = "오라클";
		String replaceStr = "java";
		
		int len = str.length();
		//int i = 0;
		String split[] = null;
		String result = null;
		for (int i = 0; i < len; i++) {
			if(str.charAt(i) == '자') {
				if(str.substring(i, i+2).equals(findStr)) {
					split = str.split(findStr, 2);
					str = split[0] + replaceStr + split[1];
					i += replaceStr.length() - 1;
				}
			}
		}
		if (split == null)
			System.out.println(findStr + "은 없습니다.");
		else
			System.out.println(str);
		
		
	}
	
	
}
