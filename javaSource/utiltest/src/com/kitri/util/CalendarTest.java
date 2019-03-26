package com.kitri.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
	
		//2019�� 03�� 26�� ���� 1�� 17�� 35��
		Calendar cal = new GregorianCalendar();
		StringBuffer str =  new StringBuffer();
		str.append(cal.get(Calendar.YEAR) + "��");
		str.append(zeroPlus(cal.get(Calendar.MONTH)+1) + "�� ");
		str.append(zeroPlus(cal.get(Calendar.DAY_OF_MONTH)) + "�� ");
		str.append((cal.get(Calendar.AM_PM) == 1 ? "���� " : "���� "));
		str.append(zeroPlus(cal.get(Calendar.HOUR)) + "�� ");
		str.append(zeroPlus(cal.get(Calendar.MINUTE)) + "�� ");	
		str.append(zeroPlus(cal.get(Calendar.SECOND)) + "�� ");
		
		System.out.println(str);
		System.out.println(Calendar.getInstance().getTime());
		//System.out.println();
		
		Date date = new Date();
	
	}
	      
	public static String zeroPlus(int value) {
		return value < 10 ? "0" + value : "" + value;
	}
}
