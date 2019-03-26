package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class ReverseTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "!!! avaj olleh";
		String rev = "";
		
		//1.
		int length = str.length();
		for(int i = length-1; i >= 0 ; i--) {
			rev += str.charAt(i);
		}
		System.out.println(rev);
		rev = "";
		
		//2.
		char[] c = str.toCharArray();
		int len = c.length;
		for (int i = len - 1 ; i >= 0 ; i--) {
			rev += c[i];
		}
		System.out.println(rev);
		rev = "";
		
		//3.
		char temp;
		for(int i = 0 ; i<len/2 ; i++) {
			temp = c[i];
			c[i] = c[len - i - 1];
			c[len-i-1] = temp;
		}
		rev = String.valueOf(c);
		System.out.println(rev);
		rev = "";
		
		//4.
		c = str.toCharArray();
		len = c.length;
		for (int i = 0; i < len-1 ; i++) {
			for(int j = 0 ; j < len-i-1 ; j++) {
				temp = c[j];
				c[j] = c[j+1];
				c[j+1] = temp;
			}
		}
		rev = String.valueOf(c);
		System.out.println(rev);
		
		System.out.println("e는 " + (rev.indexOf('e')+1) + "번째 있습니다.");
		System.out.println("e는 " + (rev.indexOf('e')+1) + "번째 있습니다.");
		rev = "";
		
		//5.
		len = str.length();
		for (int i = len-1; i >= 0; i--) {
			rev = rev.concat(String.valueOf(str.charAt(i)));
		}
		System.out.println(rev);
		rev = "";
		
		//6. 
		String[] s = str.split(" ");
		len = s.length;
		for (int i = len - 1; i >= 0 ; i--) {
			c = s[i].toCharArray();
			for(int j = c.length-1 ; j >= 0 ; j-- ) {
				rev += c[j];
			}
			rev += " ";
		}
		rev = rev.trim();
		System.out.println(rev);
		rev = "";
		
		//7. 
		byte[] b = str.getBytes("utf-8");
		byte btemp;
		len = b.length;
		for (int i = 0; i < len/2 ; i++) {
			btemp = b[i];
			b[i] = b[len-i-1];
			b[len-i-1] = btemp;
			//byte[] b2 = {b[i]};
			//rev += new String(b2);
		}
		rev = new String(b, "utf-8");
		System.out.println(rev);
		
		//최종
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
	}
}
