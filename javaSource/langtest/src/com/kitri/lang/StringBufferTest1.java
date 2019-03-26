package com.kitri.lang;

public class StringBufferTest1 {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("hello ");
		
		System.out.println("1. sb == " + sb);
		int cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		
		sb.append("java");
		System.out.println("2. sb == " + sb);
		
		sb.append(" !!!!!");
		System.out.println("3. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
	
		sb.append(" !!!!!!!");
		System.out.println("4. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		
		sb.insert(10, "@@@");
		System.out.println("5. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		
		sb.delete(10, 12);
		System.out.println("6. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		
		sb.deleteCharAt(10);
		System.out.println("7. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		
		sb.replace(6, 10, "�ڹ�12345678");
		System.out.println("8. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		
		sb.reverse();
		System.out.println("9. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		sb.reverse();

		sb.setCharAt(9, '@');
		System.out.println("10. sb == " + sb);
		cap = sb.capacity();
		System.out.println("�ʱ� ũ�� : " + cap + "\t���ڿ� �� : "+ sb.length());
		sb.reverse();
		
		String s1 = new String(sb);
		String s2 = sb.toString();
		
		String str = "hello �ڹ� !�ڹ�!!";
		String findStr = "�ڹ�";
		String findStr2 = "����Ŭ";
		String replaceStr = "java";
		
		int len = str.length();
		//int i = 0;
		String split[] = null;
		String result = null;
		for (int i = 0; i < len; i++) {
			if(str.charAt(i) == '��') {
				if(str.substring(i, i+2).equals(findStr)) {
					split = str.split(findStr, 2);
					str = split[0] + replaceStr + split[1];
					i += replaceStr.length() - 1;
				}
			}
		}
		if (split == null)
			System.out.println(findStr + "�� �����ϴ�.");
		else
			System.out.println(str);
		
		
	}
	
	
}
