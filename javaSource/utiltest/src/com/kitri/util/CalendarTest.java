package com.kitri.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
	
		//2019년 03월 26일 오후 1시 17분 35초
		Calendar cal = new GregorianCalendar();
		StringBuffer str =  new StringBuffer();
		str.append(cal.get(Calendar.YEAR) + "년");
		str.append(zeroPlus(cal.get(Calendar.MONTH)+1) + "월 ");
		str.append(zeroPlus(cal.get(Calendar.DAY_OF_MONTH)) + "일 ");
		str.append((cal.get(Calendar.AM_PM) == 1 ? "오후 " : "오전 "));
		str.append(zeroPlus(cal.get(Calendar.HOUR)) + "시 ");
		str.append(zeroPlus(cal.get(Calendar.MINUTE)) + "분 ");	
		str.append(zeroPlus(cal.get(Calendar.SECOND)) + "초 ");
		
		System.out.println(str);
		System.out.println(Calendar.getInstance().getTime());
		//System.out.println();
		
		Date date = new Date();
	
	}
	      
	public static String zeroPlus(int value) {
		return value < 10 ? "0" + value : "" + value;
	}
}
