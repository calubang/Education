package com.kitri.util;

import java.text.DecimalFormat;
import java.text.Format;

public class NumberFormatTest {
	public static void main(String[] args) {
		
		Double number = 12345678912345.987654;
		// 3자리 콤마 + 소수점은 2자리만
		
		Format f = new DecimalFormat(",###.##");
		
		String num = f.format(number);
		System.out.println(num);
	}
}
