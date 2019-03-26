package com.kitri.lang;

//

public class WrapperClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean b = new Boolean("tㅁㅇㄻ");
		boolean b2 = b.booleanValue();
		boolean b3 = Boolean.parseBoolean("true");
		
		if (b2) 
			System.out.println("b2는 true이다");
		if (b3)
			System.out.println("b3는 true이다");
		
		String s = "123";
		Integer i = new Integer(s);
		int x = i.intValue();
		x = Integer.parseInt(s);
		System.out.println(x + 3);
		
		s = "123.45";
		double d = Double.parseDouble(s);
		
		Double dd = new Double(123.11);
		d = dd;
		
		System.out.println(d);
		
		
	}
	

}
