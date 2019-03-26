package com.kitri.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
	//2019.03.26 14:25:30
	public static void main(String[] args) {
		Date date = new Date();
		Format f = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ HH:mm:ss");
		
		String today = f.format(date);
		System.out.println(today);
	}
}
