package com.kitri.util;

import java.text.DecimalFormat;
import java.text.Format;

public class NumberFormatTest {
	public static void main(String[] args) {
		
		Double number = 12345678912345.987654;
		// 3�ڸ� �޸� + �Ҽ����� 2�ڸ���
		
		Format f = new DecimalFormat(",###.##");
		
		String num = f.format(number);
		System.out.println(num);
	}
}
